package com.xplore.web.vo;

import com.xplore.web.domain.permission.Admin;
import com.xplore.web.domain.permission.Perm;
import com.xplore.web.domain.permission.Resource;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
public class AdminSession {

    public static final String KEY_LOCKER_ADMIN = "protops_admin";

    private Admin admin;

    private String currentUri;

    private Resource currentResource;
    private Perm currentPerm;

    public AdminSession(Admin admin) {
        this.admin = admin;
    }

    private Map<String, List<MenuItem>> menu;

    private Set<Resource> resources;

    // lastUrl
    private String lastUrl;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    private Map<String, List<MenuItem>> initMenu() {

        Map<String, List<MenuItem>> sortedMenu = new LinkedHashMap<String, List<MenuItem>>();

        ArrayList<Resource> sortedList = new ArrayList<Resource>(getResources());

        Collections.sort(sortedList, new Comparator<Resource>() {
            @Override
            public int compare(Resource o1, Resource o2) {

                Integer weight1 = o1.getWeight();
                Integer weight2 = o2.getWeight();

                if (weight1 > weight2) {
                    return -1;
                } else if (weight1 == weight2) {
                    return 0;
                } else {
                    return 1;

                }
            }
        });

        for (Resource vo : sortedList) {

            if (StringUtils.isEmpty(vo.getParentName())) {
                continue;
            }

            List<MenuItem> items = sortedMenu.get(vo.getParentName());

            MenuItem item = new MenuItem(vo);

            if (items == null) {

                items = new ArrayList<MenuItem>();

                items.add(item);

                sortedMenu.put(vo.getParentName(), items);

                continue;

            }

            items.add(item);

        }

        menu = sortedMenu;


        return menu;
    }

    public Map<String, List<MenuItem>> getMenu() {

        if (menu != null) {
            return menu;
        }

        initMenu();

        return menu;
    }

    public void setMenu(Map<String, List<MenuItem>> menu) {
        this.menu = menu;
    }

    public void login(HttpSession session) {
        session.setAttribute(KEY_LOCKER_ADMIN, this);
    }

    public static boolean isLogin(HttpSession session) {

        return session.getAttribute(KEY_LOCKER_ADMIN) == null ? false : true;

    }

    public static AdminSession getCurrentAdmin(HttpSession session) {

        return (AdminSession) session.getAttribute(KEY_LOCKER_ADMIN);

    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public String getLastUrl() {
        return lastUrl;
    }

    public void setLastUrl(String lastUrl) {
        this.lastUrl = lastUrl;
    }

    public void logout(HttpSession httpSession) {
        httpSession.setAttribute(KEY_LOCKER_ADMIN, null);
    }

    public void setCurrentUri(String currentUri) {
        this.currentUri = currentUri;
    }

    public String getCurrentUri() {
        return currentUri;
    }

    public Resource getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(Resource currentResource) {
        this.currentResource = currentResource;
    }

    public Perm getCurrentPerm() {
        return currentPerm;
    }

    public void setCurrentPerm(Perm currentPerm) {
        this.currentPerm = currentPerm;
    }
}
