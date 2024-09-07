package org.staff.staffsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StaffSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffSystemApplication.class, args);
    }

}
