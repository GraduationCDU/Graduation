package cdu.gu.common.config;

import io.minio.CreateMultipartUploadResponse;
import io.minio.ListPartsResponse;
import io.minio.MinioAsyncClient;
import io.minio.messages.Part;
import lombok.SneakyThrows;

import java.util.List;

/**
 * 扩展MinioAsyncClient类，用于与MinIO对象存储服务进行互动
 */
public class MinioClientConfig extends MinioAsyncClient {
    /**
     * 接收MinioAsyncClient类型的参数，初始化一个MinioClientConfig实例
     * @param client
     */
    protected MinioClientConfig(MinioAsyncClient client) {
        super(client);
    }

    /**
     * @param bucket 存储桶名字
     * @param filename 对象名称
     * @return
     */
    @SneakyThrows
    public String uploadId(String bucket,String filename){
        /**
         * super.createMultipartUpload用于初始化一个多部分上传操作
         */
        CreateMultipartUploadResponse response =
                super.createMultipartUpload(bucket,null,filename,null,null);
        return response.result().uploadId();
    }

    /**
     * 通过super.completeMultipartUpload完成多部分上传操作
     * @param bucketName 存储桶名字
     * @param objectName 对象名字
     * @param uploadId 多部分上传id
     */
    @SneakyThrows
    public void merge(String bucketName,String objectName,String uploadId){
        ListPartsResponse listPartsResponse =
                super.listParts(bucketName,null,objectName,10000,0,uploadId,null,null);
        List<Part> partList = listPartsResponse.result().partList();
        Part[] parts = new Part[10000];
        int paerNumber = 1;
        for (Part part:partList){
            parts[paerNumber-1] = new Part(paerNumber,part.etag());
            paerNumber++;
        }
        super.completeMultipartUpload(bucketName,null,objectName,uploadId,parts,null,null);
    }
}
