package com.xplore.web.controller.web;

import com.xplore.web.domain.Suggestion;
import com.xplore.web.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by damen on 2014/12/26.
 */
@Controller
@RequestMapping(value = "web/suggestion")
public class SuggestionController extends BaseController{

    @Autowired
    SuggestionService suggestionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String suggestion(Model model){
        return "web/suggestion";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String doSuggestion(@ModelAttribute("form") Suggestion suggestion, Model model){

        suggestionService.save(suggestion);

        return "redirect:suggestion";
    }
}
