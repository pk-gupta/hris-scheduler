package org.marlabs.HRISDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"org.marlabs.*"})
@SpringBootApplication
public class HRISDetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HRISDetailsApplication.class, args);
    }
}
