package cdu.gu.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class back_endConfig {
    @Value("${spring.profiles.active}")
    private String env;

    @Value("${playedu.core.testing}")
    private Boolean testing;

    @Value("${playedu.limiter.duration}")
    private Long limiterDuration;

    @Value("${playedu.limiter.limit}")
    private Long limiterLimit;
}
