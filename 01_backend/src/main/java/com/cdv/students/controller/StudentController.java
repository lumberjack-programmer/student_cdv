package com.cdv.students.controller;

import com.cdv.students.entity.Student;
import com.cdv.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "/api")
public class StudentController {

    @Autowired
    private StudentService studentService;
//
//    public boolean saveStudent(@RequestBody Student student) {
//
//        return studentService.saveStudent(student);
//    }
//
    @GetMapping("/students")
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{theName}")
    public List<Student> getStudentByName(@PathVariable("theName") String theName) {
        return studentService.getStudentByName(theName);
    }

    @PostMapping("/students")
    public boolean add(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/students/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("/students/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return studentService.delete(id);
    }




//
//    @DeleteMapping("delete-student/{student_id}")
//    public boolean deleteStudent(@PathVariable("student_id") Long id, Student student) {
//        student.setId(id);
//        return studentService.deleteStudent(student);
//    }
//
//    @GetMapping("student/{student_id}")
//    public List<Student> allstudentByID(@PathVariable("student_id") Long id,Student student) {
//        student.setId(id);
//        return studentService.getStudentByID(student);
//
//    }
//
//    @PostMapping("update-student/{student_id}")
//    public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") Long id) {
//        student.setId(id);
//        return studentService.updateStudent(student);
//    }


}
