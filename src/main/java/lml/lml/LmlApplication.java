package lml.lml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.lml.demolml.repository")
@SpringBootApplication
public class LmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmlApplication.class, args);
    }

}
