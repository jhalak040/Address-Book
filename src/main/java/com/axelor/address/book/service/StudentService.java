package com.axelor.address.book.service;

import java.util.List;
import  com.axelor.address.book.db.Student;

public interface StudentService {

  public void insertStudent(Student student);

  public void deleteStudent(int studentID);

  public void updateStudent(Student student);

  public List<Student> getAllStudent();

  public Student getStudentById(int studentId);

  public List<Student> searchStudent(String searchString);

}
