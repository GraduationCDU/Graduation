package cdu.gu.common.service;

import cdu.gu.common.exception.NotFoundException;
import cdu.gu.common.pojo.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface AdminRoleService extends IService<AdminRole> {
    AdminRole getBySlug(String slug);

    Integer initSuperAdminRole();

    void createWithPermissionIds(String name, Integer[] permissionIds);

    void relatePermissions(AdminRole role, Integer[] permissionIds);

    void resetRelatePermissions(AdminRole role, Integer[] permissionIds);

    void updateWithPermissionIds(AdminRole role, String name, Integer[] permissionIds);

    AdminRole findOrFail(Integer id) throws NotFoundException;

    void removeWithPermissions(AdminRole role);

    List<Integer> getPermissionIdsByRoleId(Integer roleId);

    List<Integer> getPermissionIdsByRoleIds(List<Integer> roleIds);

    void removeRelatePermissionByRoleId(Integer roleId);
}
