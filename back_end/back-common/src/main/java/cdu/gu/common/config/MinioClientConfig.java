package cdu.gu.common.config;

import io.minio.MinioAsyncClient;

public class MinioClientConfig extends MinioAsyncClient {

    protected MinioClientConfig(MinioAsyncClient client) {
        super(client);
    }
}
