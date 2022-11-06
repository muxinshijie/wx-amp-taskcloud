package muxin.mlearning.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "muxin.mlearning")
public class MlearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(MlearningApplication.class, args);
    }
}
