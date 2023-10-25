package cdu.gu.common.constant;

import java.util.ArrayList;
import java.util.List;

public class FrontendConstant {
    public static final List<String> UN_AUTH_URI_WHITELIST =
            new ArrayList<>() {
                {
                    add("/api/v1/system/config");
                    add("/api/v1/system/image-captcha");
                    add("/api/v1/auth/login/password");
                    add("/api/v1/auth/login/ldap");
                }
            };

    public static final String USER_UPLOAD_IMAGE_TYPE_AVATAR = "avatar";

    public static final String USER_UPLOAD_IMAGE_SCENE_AVATAR = "avatar";

    public static final String DIR_AVATAR = "user/avatar/";
}
