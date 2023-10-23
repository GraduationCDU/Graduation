package cdu.gu.common.service.impl;

import cdu.gu.common.mapper.AdminRoleMapper;
import cdu.gu.common.pojo.AdminRole;
import cdu.gu.common.service.AdminRolePermissionService;
import cdu.gu.common.service.AdminRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
        implements AdminRoleService {
    @Autowired
    private AdminRolePermissionService rolePermissionService;

    @Autowired private AdminUserRoleService userRoleService;

    @Override
    public AdminRole getBySlug(String slug) {
        return getOne(query().getWrapper().eq("slug", slug));
    }

    @Override
    public Integer initSuperAdminRole() {
        AdminRole role = new AdminRole();

        role.setName("超级管理员");
        role.setSlug(BackendConstant.SUPER_ADMIN_ROLE);
        role.setCreatedAt(new Date());
        role.setUpdatedAt(new Date());

        save(role);

        return role.getId();
    }

    @Override
    @Transactional
    public void createWithPermissionIds(String name, Integer[] permissionIds) {
        AdminRole role = new AdminRole();

        role.setName(name);
        role.setSlug(HelperUtil.randomString(12));
        role.setCreatedAt(new Date());
        role.setUpdatedAt(new Date());

        save(role);

        relatePermissions(role, permissionIds);
    }

    @Override
    public void relatePermissions(AdminRole role, Integer[] permissionIds) {
        if (permissionIds == null || permissionIds.length == 0) {
            return;
        }

        List<AdminRolePermission> rolePermissions = new ArrayList<>();
        for (int i = 0; i < permissionIds.length; i++) {
            AdminRolePermission rolePermission = new AdminRolePermission();
            rolePermission.setRoleId(role.getId());
            rolePermission.setPermId(permissionIds[i]);
            rolePermissions.add(rolePermission);
        }
        rolePermissionService.saveBatch(rolePermissions);
    }

    @Override
    public void resetRelatePermissions(AdminRole role, Integer[] permissionIds) {
        removeRelatePermissionByRoleId(role.getId());
        relatePermissions(role, permissionIds);
    }

    @Override
    @Transactional
    public void updateWithPermissionIds(AdminRole role, String name, Integer[] permissionIds) {
        if (!role.getName().equals(name)) {
            AdminRole newRole = new AdminRole();
            newRole.setId(role.getId());
            newRole.setName(name);
            updateById(newRole);
        }

        resetRelatePermissions(role, permissionIds);
    }

    @Override
    public AdminRole findOrFail(Integer id) throws NotFoundException {
        AdminRole role = getOne(query().getWrapper().eq("id", id));
        if (role == null) {
            throw new NotFoundException("管理角色不存在");
        }
        return role;
    }

    @Override
    @Transactional
    public void removeWithPermissions(AdminRole role) {
        removeRelatePermissionByRoleId(role.getId());
        removeById(role.getId());
        userRoleService.remove(userRoleService.query().getWrapper().eq("role_id", role.getId()));
    }

    @Override
    public List<Integer> getPermissionIdsByRoleId(Integer roleId) {
        QueryWrapper<AdminRolePermission> wrapper =
                rolePermissionService.query().getWrapper().eq("role_id", roleId);
        List<AdminRolePermission> rolePermissions = rolePermissionService.list(wrapper);
        List<Integer> ids = new ArrayList<>();
        for (AdminRolePermission rolePermission : rolePermissions) {
            ids.add(rolePermission.getPermId());
        }
        return ids;
    }

    @Override
    public List<Integer> getPermissionIdsByRoleIds(List<Integer> roleIds) {
        QueryWrapper<AdminRolePermission> wrapper =
                rolePermissionService.query().getWrapper().in("role_id", roleIds);
        List<AdminRolePermission> rolePermissions = rolePermissionService.list(wrapper);
        List<Integer> ids = new ArrayList<>();
        for (AdminRolePermission rolePermission : rolePermissions) {
            ids.add(rolePermission.getPermId());
        }
        return ids;
    }

    @Override
    public void removeRelatePermissionByRoleId(Integer roleId) {
        QueryWrapper<AdminRolePermission> wrapper =
                rolePermissionService.query().getWrapper().eq("role_id", roleId);
        rolePermissionService.remove(wrapper);
    }
}
