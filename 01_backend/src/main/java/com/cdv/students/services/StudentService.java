package com.cdv.students.services;


import com.cdv.students.dao.StudentRepository;
import com.cdv.students.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    private final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public boolean patternMatches(String emailAddress) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentByName(String theName) {
        return studentRepository.findStudentByNameContains(theName);
    }

    public boolean save(Student student) {
        boolean status = false;
        try {
            if (!patternMatches(student.getEmail())) {
                return false;
            }
            studentRepository.save(student);
            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean delete(Long id) {
        boolean status = false;
        try {
            studentRepository.delete(studentRepository.getReferenceById(id));
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean update(Student student) {
        boolean status = false;
        try {

            if (studentRepository.findById(student.getId()).isPresent()) {
                Student studentFound = studentRepository.getReferenceById(student.getId());
                if (!patternMatches(student.getEmail())) {
                    return false;
                }
                studentFound.setBranch(student.getBranch());
                studentFound.setEmail(student.getEmail());
                studentFound.setName(student.getName());
                studentRepository.save(studentFound);
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


}
