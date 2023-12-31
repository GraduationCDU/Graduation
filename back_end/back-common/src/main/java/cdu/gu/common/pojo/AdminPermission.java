package cdu.gu.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "admin_permissions")
@Data
public class AdminPermission implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 类型[行为:action,数据:data] */
    private String type;

    /** 分组 */
    @JsonProperty("group_name")
    private String groupName;

    /** 升序 */
    private Integer sort;

    /** 权限名 */
    private String name;

    /** slug */
    private String slug;

    @JsonProperty("created_at")
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminPermission other = (AdminPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getType() == null
                ? other.getType() == null
                : this.getType().equals(other.getType()))
                && (this.getGroupName() == null
                ? other.getGroupName() == null
                : this.getGroupName().equals(other.getGroupName()))
                && (this.getSort() == null
                ? other.getSort() == null
                : this.getSort().equals(other.getSort()))
                && (this.getName() == null
                ? other.getName() == null
                : this.getName().equals(other.getName()))
                && (this.getSlug() == null
                ? other.getSlug() == null
                : this.getSlug().equals(other.getSlug()))
                && (this.getCreatedAt() == null
                ? other.getCreatedAt() == null
                : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSlug() == null) ? 0 : getSlug().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", groupName=").append(groupName);
        sb.append(", sort=").append(sort);
        sb.append(", name=").append(name);
        sb.append(", slug=").append(slug);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}