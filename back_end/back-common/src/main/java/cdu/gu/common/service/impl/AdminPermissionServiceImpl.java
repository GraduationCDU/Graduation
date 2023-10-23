package cdu.gu.common.service.impl;

import cdu.gu.common.mapper.AdminPermissionMapper;
import cdu.gu.common.pojo.AdminPermission;
import cdu.gu.common.service.AdminPermissionService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
@Service
public class AdminPermissionServiceImpl extends ServiceImpl<AdminPermissionMapper,AdminPermission>
        implements AdminPermissionService {
    @Override
    public HashMap<String, Boolean> allSlugs() {
        return null;
    }

    @Override
    public List<AdminPermission> listOrderBySortAsc() {
        return null;
    }

    @Override
    public HashMap<String, Boolean> getSlugsByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Integer> allIds() {
        return null;
    }

    @Override
    public List<AdminPermission> chunks(List<Integer> ids) {
        return null;
    }

    @Override
    public boolean saveBatch(Collection<AdminPermission> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<AdminPermission> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<AdminPermission> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(AdminPermission entity) {
        return false;
    }

    @Override
    public AdminPermission getOne(Wrapper<AdminPermission> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<AdminPermission> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<AdminPermission> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<AdminPermission> getBaseMapper() {
        return null;
    }

    @Override
    public Class<AdminPermission> getEntityClass() {
        return null;
    }
}
