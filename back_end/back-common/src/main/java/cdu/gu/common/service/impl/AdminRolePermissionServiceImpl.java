package cdu.gu.common.service.impl;


import cdu.gu.common.mapper.AdminRolePermissionMapper;
import cdu.gu.common.pojo.AdminRolePermission;
import cdu.gu.common.service.AdminRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminRolePermissionServiceImpl
        extends ServiceImpl<AdminRolePermissionMapper, AdminRolePermission>
        implements AdminRolePermissionService {}
