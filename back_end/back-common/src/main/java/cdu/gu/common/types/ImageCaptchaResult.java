package cdu.gu.common.types;

import lombok.Data;

@Data
public class ImageCaptchaResult {
    public String key;

    public String image;

    public String code;
}
