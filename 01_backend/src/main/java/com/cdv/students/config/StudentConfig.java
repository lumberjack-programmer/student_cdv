package com.cdv.students.config;

import com.cdv.students.dao.StudentRepository;
import com.cdv.students.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student("John", "john@domain.com", "development"));
            studentRepository.save(new Student("Danny", "danny@domain.com", "management"));
        };
    }
}
