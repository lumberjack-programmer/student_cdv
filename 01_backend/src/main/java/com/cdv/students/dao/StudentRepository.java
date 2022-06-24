package com.cdv.students.dao;

import com.cdv.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@CrossOrigin(origins="http://localhost:4200")
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    List<Student> findStudentByNameContains(@RequestParam("name") String name);
    List<Student> findStudentByBranchContains(@RequestParam("name") String name);
    List<Student> findStudentByEmailContains(@RequestParam("name") String name);


    //    public boolean saveStudent(Student student);
//    public List<Student> getStudents();
//    public boolean deleteStudent(Student student);
//    public List<Student> getStudentByID(Student student);
//    public boolean updateStudent(Student student);
}
