package cdu.gu.common.util.ldap;

import lombok.Data;

import java.util.List;
@Data
public class LdapTransformUser {
    private String id;

    private String dn;

    private String cn;

    private List<String> ou;

    private String email;

    private String uid;
}
