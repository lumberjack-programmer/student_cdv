package com.cdv.students.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200/**")
public class StudentDaoImpl  {



//    private SessionFactory sessionFactory;
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public boolean saveStudent(Student student) {
//        boolean status = false;
//        try {
//            sessionFactory.getCurrentSession().save(student);
//            status = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//    }
//
//    @Override
//    public List<Student> getStudents() {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Query<Student> query = currentSession.createQuery("from Student", Student.class);
//        List<Student> list = query.getResultList();
//        return list;
//    }
//
//    @Override
//    public boolean deleteStudent(Student student) {
//        boolean status = false;
//        try {
//            sessionFactory.getCurrentSession().delete(student);
//            status = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//    }
//
//    @Override
//    public List<Student> getStudentByID(Student student) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Query<Student> query = currentSession.createQuery("from Student where student_id=:id", Student.class);
//        query.setParameter("student_id", student.getId());
//        List<Student> list = query.getResultList();
//        return list;
//    }
//
//    @Override
//    public boolean updateStudent(Student student) {
//        boolean status = false;
//        try {
//            sessionFactory.getCurrentSession().update(student);
//            status = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//    }
}
