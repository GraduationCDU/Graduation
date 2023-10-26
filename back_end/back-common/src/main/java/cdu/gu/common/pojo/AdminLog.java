package cdu.gu.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@TableName(value = "admin_logs")
@Data
public class AdminLog implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**管理员*/
    @JsonProperty("admin_id")
    private Integer adminId;
    /**管理员姓名*/
    @JsonProperty("admin_name")
    private String adminName;
    /**模块*/
    private String module;
    /**标题*/
    private String title;
    /**操作指令*/
    private Integer opt;
    /**请求方法*/
    private String method;
    /**请求方式*/
    @JsonProperty("request_method")
    private String requestMethod;
    /** 请求URL */
    private String url;

    /** 请求参数 */
    private String param;

    /** 返回参数 */
    private String result;

    /** ip */
    private String ip;

    /** 地址 */
    @JsonProperty("ip_area")
    private String ipArea;

    /** 备注 */
    @JsonProperty("error_msg")
    private String errorMsg;

    @JsonProperty("created_at")
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        AdminLog other = (AdminLog) that;
        return(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getAdminId() == null
                ? other.getAdminId() == null
                : this.getAdminId().equals(other.getAdminId()))
                && (this.getAdminName() == null
                ? other.getAdminName() == null
                : this.getAdminName().equals(other.getAdminName()))
                && (this.getModule() == null
                ? other.getModule() == null
                : this.getModule().equals(other.getModule()))
                && (this.getTitle() == null
                ? other.getTitle() == null
                : this.getTitle().equals(other.getTitle()))
                && (this.getOpt() == null
                ? other.getOpt() == null
                : this.getOpt().equals(other.getOpt()))
                && (this.getMethod() == null
                ? other.getMethod() == null
                : this.getMethod().equals(other.getMethod()))
                && (this.getRequestMethod() == null
                ? other.getRequestMethod() == null
                : this.getRequestMethod().equals(other.getRequestMethod()))
                && (this.getUrl() == null
                ? other.getUrl() == null
                : this.getUrl().equals(other.getUrl()))
                && (this.getParam() == null
                ? other.getParam() == null
                : this.getParam().equals(other.getParam()))
                && (this.getResult() == null
                ? other.getResult() == null
                : this.getResult().equals(other.getResult()))
                && (this.getIp() == null
                ? other.getIp() == null
                : this.getIp().equals(other.getIp()))
                && (this.getIpArea() == null
                ? other.getIpArea() == null
                : this.getIpArea().equals(other.getIpArea()))
                && (this.getErrorMsg() == null
                ? other.getErrorMsg() == null
                : this.getErrorMsg().equals(other.getErrorMsg()))
                && (this.getCreatedAt() == null
                ? other.getCreatedAt() == null
                : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminName() == null) ? 0 : getAdminName().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getOpt() == null) ? 0 : getOpt().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result =
                prime * result + ((getRequestMethod() == null) ? 0 : getRequestMethod().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getIpArea() == null) ? 0 : getIpArea().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getClass().getSimpleName());
        str.append(" [");
        str.append("Hash = ").append(hashCode());
        str.append(", id=").append(id);
        str.append(", adminId=").append(adminId);
        str.append(", adminName=").append(adminName);
        str.append(", module=").append(module);
        str.append(", title=").append(title);
        str.append(", opt=").append(opt);
        str.append(", method=").append(method);
        str.append(", requestMethod=").append(requestMethod);
        str.append(", url=").append(url);
        str.append(", param=").append(param);
        str.append(", result=").append(result);
        str.append(", ip=").append(ip);
        str.append(", ipArea=").append(ipArea);
        str.append(", errorMsg=").append(errorMsg);
        str.append(", createdAt=").append(createdAt);
        str.append(", serialVersionUID=").append(serialVersionUID);
        str.append("]");
        return str.toString();
    }
}
