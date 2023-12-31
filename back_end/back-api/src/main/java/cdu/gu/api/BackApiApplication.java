package cdu.gu.api;

import cdu.gu.common.config.UniqueNameGeneratorConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@ComponentScan(
        basePackages = {"cdu.gu"},
        nameGenerator = UniqueNameGeneratorConfig.class)
@MapperScan("xyz.playedu.**.mapper")
public class BackApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackApiApplication.class, args);
    }
}
