package cdu.gu.common.mapper;

import cdu.gu.common.pojo.AdminLog;
import cdu.gu.common.types.paginate.AdminLogPaginateFiler;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLogMapper extends BaseMapper<AdminLogMapper> {
    List<AdminLog> paginate(AdminLogPaginateFiler filer);

    Long paginateCount(AdminLogPaginateFiler filer);
}
