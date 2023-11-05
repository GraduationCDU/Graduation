package cdu.gu.common.types;

import lombok.Data;

@Data
public class UploadFileInfo {
    private String originalName;
    private String extension;
    private long size;
    private String saveName;
    private String resourceType;
    private String savePath;
    private String url;
}
