package com.xplore.web.service.permission;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.dao.permission.AdminDao;
import com.xplore.web.domain.permission.Admin;
import com.xplore.web.domain.permission.Perm;
import com.xplore.web.domain.permission.Resource;
import com.xplore.web.domain.permission.Role;
import com.xplore.web.exception.AdminException;
import com.xplore.web.util.SignUtils;
import com.xplore.web.vo.AdminSession;
import com.xplore.web.vo.MenuItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by damen on 2014/11/22.
 */
@Service
@Transactional
public class LoginService {

    @Autowired
    AdminDao adminDao;

    public AdminSession tryLogin(String username, String password) throws AdminException {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new AdminException(ResponseCodes.KEY_LOGIN_AUTH_ERR);
        }

        String md5Password = SignUtils.md5(password);

        Admin admin = adminDao.hit(username, md5Password);

        if (admin == null) {
            throw new AdminException(ResponseCodes.KEY_LOGIN_AUTH_ERR);
        }

        AdminSession adminSession = new AdminSession(admin);

        Set<Resource> resourceSet = mergeResources(admin);

        if (resourceSet == null || resourceSet.size() == 0) {
            throw new AdminException(ResponseCodes.KEY_PERMISSION_ERR);
        }

        adminSession.setResources(resourceSet);

        adminSession.setLastUrl("redirect:" + AdminConfig.get("key_admin_path") + "/admin/" + redirectToDefault(adminSession));



        return adminSession;

    }

    public Set<Resource> mergeResources(Admin admin) {

        // 根据admin获取角色列表
        List<Role> roles = admin.getRoles();

        // 如果没有角色，直接再见
        if (roles.size() == 0) {
            return null;
        }

        // 获取角色可以取得的资源，并且需要merge
        Comparator<Resource> comparator = new Comparator<Resource>() {
            @Override
            public int compare(Resource o1, Resource o2) {
                if (o1.getUri().length() > o2.getUri().length()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        TreeSet<Resource> mergedResources = new TreeSet<Resource>(comparator);
        for (Role role : roles) {

            Set<Resource> resources = role.getResources();

            for (Resource resource : resources) {

                mergedResources.add(resource);

            }

        }

        return mergedResources;
    }

    private String redirectToDefault(AdminSession adminSession) {

        Map<String, List<MenuItem>> menu = adminSession.getMenu();

        // 只有在menu里面的resource才能显示
        for (Map.Entry<String, List<MenuItem>> entry : menu.entrySet()) {

            List<MenuItem> menuItems = entry.getValue();

            for (MenuItem menuItem : menuItems) {

                String uri = menuItem.getResourceUri();

                for (Resource resource : adminSession.getResources()) {

                    // 如果父节点名称为空，意味着这是一个在菜单中不会显示的项，不出现在
                    if (StringUtils.isEmpty(resource.getParentName())) {
                        continue;
                    }


                    if (StringUtils.equals(uri, resource.getUri())) {

                        List<Perm> perms = resource.getPerms();

                        if (perms == null || perms.size() == 0) {
                            continue;
                        }

                        return resource.getUri() + "/" + perms.get(0).getUri();


                    }

                }

            }

        }

        return "welcome";

    }
}
