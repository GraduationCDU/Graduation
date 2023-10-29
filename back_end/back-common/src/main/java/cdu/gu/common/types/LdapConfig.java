package cdu.gu.common.types;

import lombok.Data;

@Data
public class LdapConfig {
    private Boolean enabled;
    private String url;
    private String adminUser;
    private String adminPass;
    private String baseDN;
}
