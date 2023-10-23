package cdu.gu.common.service;

import cdu.gu.common.pojo.AdminPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

public interface AdminPermissionService extends IService<AdminPermission> {
    HashMap<String, Boolean> allSlugs();

    List<AdminPermission> listOrderBySortAsc();

    HashMap<String, Boolean> getSlugsByIds(List<Integer> ids);

    List<Integer> allIds();

    List<AdminPermission> chunks(List<Integer> ids);
}
