package cdu.gu.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "user_department")
@Data
public class UserDepartment implements Serializable {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("dep_id")
    private Integer depId;

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
        UserDepartment other = (UserDepartment) that;
        return (this.getUserId() == null
                ? other.getUserId() == null
                : this.getUserId().equals(other.getUserId()))
                && (this.getDepId() == null
                ? other.getDepId() == null
                : this.getDepId().equals(other.getDepId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDepId() == null) ? 0 : getDepId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", depId=").append(depId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
