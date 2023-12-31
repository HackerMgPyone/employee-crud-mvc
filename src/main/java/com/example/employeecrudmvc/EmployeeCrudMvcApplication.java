package com.example.employeecrudmvc;

import com.example.employeecrudmvc.dao.CustomerDao;
import com.example.employeecrudmvc.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeCrudMvcApplication {
    private final CustomerDao customerDao;

    @Bean
    public ApplicationRunner runner() {
        return r -> {
            List.of(
                    new Customer("John", "Doe", "john@gmail.com", "55-55-55", LocalDate.of(2023,04,13)),
                    new Customer("Albert", "Myo", "albert@gmail.com", "44-55-55", LocalDate.of(2023,04,13)),
                    new Customer("Annie", "Ni", "john@gmail.com", "55-22-44", LocalDate.of(2023,04,13)),
                    new Customer("Asaki", "Hugo", "asaki@gmail.com", "44-44-22", LocalDate.of(2023,04,13)),
                    new Customer("William", "San", "william@gmail.com", "22-22-22", LocalDate.of(2023,04,13))
            ).forEach(this.customerDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCrudMvcApplication.class, args);
    }

}