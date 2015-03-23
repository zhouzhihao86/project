package com.xplore.web.controller.web;

import com.xplore.web.constants.enums.Country;
import com.xplore.web.domain.Menu;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.PlateEnglish;
import com.xplore.web.domain.Slider;
import com.xplore.web.service.SliderService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by damen on 2014/12/14.
 */
@Controller
@RequestMapping(value = "web/{lan}")
public class IndexController extends BaseController implements InitializingBean{

    @Autowired
    SliderService sliderService;

    private static List<Integer> currentSliderIds = new ArrayList<Integer>();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(@PathVariable String lan, HttpServletRequest request, Model model) {

        List<Slider> mainSlider = sliderService.getFirstImgForEachSlider(currentSliderIds);

        model.addAttribute("mainSlider", mainSlider);

        return getVm("index", lan);
    }

    @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
    public String intro(@PathVariable Integer articleId, @PathVariable String lan, Model model) {

        boolean useChineseFlags = isChinese(lan);

        Object plate = plateService.getById(articleId, useChineseFlags);

        Menu menu = null;

        if (useChineseFlags) {

            PlateChinese plateChinese = (PlateChinese) plate;

            model.addAttribute("current", model.asMap().get("plateRecent" + plateChinese.getPlateId()));

            menu = plateService.getMenuByPlateId(plateChinese.getPlateId());

        } else {

            PlateEnglish plateEnglish = (PlateEnglish) plate;

            model.addAttribute("current", model.asMap().get("plateRecent" + plateEnglish.getPlateId()));

            menu = plateService.getMenuByPlateId(plateEnglish.getPlateId());

        }

        model.addAttribute("article", plate);

        model.addAttribute("menu", menu);

        return getVm("groups", lan);
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "web/contact";
    }

    @RequestMapping(value = "bookingOnline", method = RequestMethod.GET)
    public String bookingOnline(@PathVariable String lan, Model model) {
        return getVm("bookingOnline", lan);
    }

    @RequestMapping(value = "campus/{country}", method = RequestMethod.GET)
    public String britain(@PathVariable Country country, @PathVariable String lan, Model model) {

        boolean useChineseFlags = isChinese(lan);

        Integer countryId = country.getCountryId();

        List campusList = campusService.getList(countryId, useChineseFlags);

        model.addAttribute("campusList", campusList);

        model.addAttribute("country", country);

        model.addAttribute("countryName", country.display(lan));

        return getVm("country", lan);
    }

    @RequestMapping(value = "campus/{country}/{id}", method = RequestMethod.GET)
    public String campusDetail(@PathVariable String lan, @PathVariable String country, @PathVariable Integer id, Model model) {

        boolean useChineseFlags = isChinese(lan);

        Object detail = campusService.getById(id, useChineseFlags);

        model.addAttribute("country", country);
        model.addAttribute("detail", detail);

        return getVm("campusDetail", lan);
    }

    @RequestMapping(value = "slider/{id}", method = RequestMethod.GET)
    public String slider(@PathVariable Integer id, @PathVariable String lan, Model model) {

        boolean useChineseFlags = isChinese(lan);

        List<Menu> menuList = plateService.getAllMenu();

        // 7 3 4 5 6
        List<Menu> obj = new ArrayList<Menu>();

        obj.add(menuList.get(menuList.size() - 1));

        Menu current = null;

        for(Menu menu : menuList){

            if(id == menu.getId()){
                current = menu;

            }

            if(menu.getId() == 1 || menu.getId() == 2 || menu.getId() == 7) continue;

            obj.add(menu);

        }

        model.addAttribute("current", current);

        // sliderService to get Pics;
        List<Slider> sliders = sliderService.getByMenuId(current.getId());

        model.addAttribute("sliders", sliders);

        model.addAttribute("menus", obj);

        return getVm("slider", lan);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        currentSliderIds.add(7);
        currentSliderIds.add(3);
        currentSliderIds.add(4);
        currentSliderIds.add(5);
        currentSliderIds.add(6);


    }
}