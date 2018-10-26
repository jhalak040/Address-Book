package com.axelor.address.book.service;

import java.util.List;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import com.axelor.address.book.db.Student;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class StudentServiceImpl implements StudentService {
  @Inject
  Provider<EntityManager> emp;

  @Override
  @Transactional
  public void insertStudent(Student student) {
    EntityManager em = emp.get();
    em.persist(student);
  }

  @Override
  @Transactional
  public void updateStudent(Student student) {
    EntityManager em = emp.get();
    em.merge(student);
  }

  @Override
  @Transactional
  public List<Student> getAllStudent() {
    EntityManager em = emp.get();
    return em.createQuery("from Student", Student.class).getResultList();
  }

  @Override
  @Transactional
  public void deleteStudent(int studentId) {
    EntityManager em = emp.get();
    Student s = em.find(Student.class, studentId);
    em.remove(s);
  }

  @Override
  @Transactional
  public Student getStudentById(int studentId) {
    EntityManager em = emp.get();
    return em.find(Student.class, studentId);
  }

  @Override
  @Transactional
  public List<Student> searchStudent(String namesearch) {
    EntityManager em = emp.get();
    return em.createQuery("select s from Student s Where s.firstName LIKE '%" + namesearch
        + "%' OR s.lastName LIKE '%" + namesearch + "%'", Student.class).getResultList();
  }

}
