package HBDONF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class HBDONFApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HBDONFApplication.class, args);
    }

}
