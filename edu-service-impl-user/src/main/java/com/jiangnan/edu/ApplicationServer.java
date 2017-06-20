package com.jiangnan.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 吴叶俊
 */
@SpringBootApplication
@ImportResource("classpath:spring/dubbo-provider.xml")
public class ApplicationServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
        synchronized (ApplicationServer.class) {
            while (true) {
                try {
                    ApplicationServer.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
