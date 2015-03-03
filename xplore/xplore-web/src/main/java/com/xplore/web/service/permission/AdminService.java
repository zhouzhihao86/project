package com.xplore.web.service.permission;

import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.dao.permission.AdminDao;
import com.xplore.web.dao.permission.AdminRoleRelationDao;
import com.xplore.web.dao.permission.RoleDao;
import com.xplore.web.domain.permission.Admin;
import com.xplore.web.domain.permission.Role;
import com.xplore.web.exception.AdminException;
import com.xplore.web.util.SignUtils;
import com.xplore.web.util.StringUtils;
import com.xplore.web.vo.AdminVo;
import com.xplore.web.vo.ResetForm;
import com.xplore.web.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    AdminRoleRelationDao adminRoleRelationDao;

    @Autowired
    RoleDao roleDao;


    public AdminVo getAdminVoWithMergedRole(Integer adminId) {

        Admin admin = adminDao.get(adminId);

        List<Role> roleList = roleDao.roleList();

        List<RoleVo> roleVoList = mergeRolesVoList(admin, roleList);

        AdminVo adminVo = new AdminVo(admin, roleVoList);

        return adminVo;

    }


    private List<RoleVo> mergeRolesVoList(Admin admin, List<Role> roleList) {

        List<RoleVo> roleVoList = new ArrayList<RoleVo>();

        for (Role role : roleList) {

            RoleVo vo = new RoleVo(role);

            for (Role adminRole : admin.getRoles()) {

                if (adminRole.getId() == vo.getId()) {

                    vo.setActive(true);
                    break;
                }
            }

            roleVoList.add(vo);

        }

        return roleVoList;

    }


    public List<AdminVo> list() {
        List<Admin> adminList = adminDao.list();

        List<AdminVo> adminVoList = new ArrayList<AdminVo>();

        for (Admin admin : adminList) {

            AdminVo adminVo = new AdminVo(admin);

            List<RoleVo> vos = RoleVo.toRoleVoList(admin.getRoles());

            adminVo.setRoles(vos);

            adminVoList.add(adminVo);

        }

        return adminVoList;
    }

    public void resetPassword(ResetForm resetForm) throws AdminException {

        try {

            boolean ok = resetForm.checkIdentical();
            if (!ok) {
                throw new AdminException(ResponseCodes.KEY_RESET_PWD_FAILED);
            }

            String md5Password = SignUtils.md5(resetForm.getOrigPwd());

            Admin admin = adminDao.passwordOK(resetForm.getId(), md5Password);
            if (admin == null) {
                throw new AdminException(ResponseCodes.KEY_RESET_PWD_FAILED);
            }

            md5Password = SignUtils.md5(resetForm.getNewPwd());

            admin.setPassword(md5Password);

        } catch (Exception e) {

            throw new AdminException(ResponseCodes.KEY_RESET_PWD_FAILED);

        }

    }


    public AdminVo addAdmin(AdminVo adminVo) throws AdminException {

        Admin admin = new Admin();

        admin.setRealName(adminVo.getRealName());
        admin.setMobile(adminVo.getMobile());
        admin.setUsername(adminVo.getUsername());
        admin.setRecSt(1);

        String md5Password = SignUtils.md5(adminVo.getPwd());
        admin.setPassword(md5Password);

        adminDao.save(admin);

        adminVo.setId(admin.getId());

        List<Object[]> dataSet = prepareAdminRoleData(adminVo);

        adminRoleRelationDao.batchUpdate(dataSet);

        return adminVo;
    }

    public AdminVo editAdmin(AdminVo adminVo) throws AdminException {

        adminRoleRelationDao.delAdminRoles(adminVo.getId());

        List<Object[]> dataSet = prepareAdminRoleData(adminVo);

        adminRoleRelationDao.batchUpdate(dataSet);

        Admin admin = adminDao.get(adminVo.getId());

        admin.setMobile(adminVo.getMobile());
        admin.setRealName(adminVo.getRealName());
        admin.setUsername(adminVo.getUsername());


        adminDao.save(admin);

        List<RoleVo> vos = RoleVo.toRoleVoList(admin.getRoles());

        adminVo.setRoles(vos);

        return adminVo;

    }

    private List<Object[]> prepareAdminRoleData(AdminVo adminVo) {

        List<Integer> roleIdList = StringUtils.toIntegerList(adminVo.getRoleIds());

        List<Object[]> dataSet = new ArrayList<Object[]>();

        // 遍历新提交的roleId，保留相同的
        for (Integer id : roleIdList) {

            Object[] obj = new Object[3];
            obj[0] = adminVo.getId();
            obj[1] = id;
            obj[2] = 1;
            dataSet.add(obj);
        }

        return dataSet;
    }

    public void delAdmin(Integer adminId) throws AdminException {

        try {

            adminDao.delete(adminId);

        } catch (Exception e) {
            throw new AdminException(ResponseCodes.KEY_DEL_ADMIN_FAILED);
        }


    }

    public List<Role> getRoleList() {
        return roleDao.roleList();
    }
}
