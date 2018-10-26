package com.axelor.address.book.db;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import  com.axelor.address.book.db.Student;

@Entity
public class Contact {



  @ManyToOne(cascade = CascadeType.ALL)
  // @JoinColumn
  private Student student;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int contactId;


  private String contactNum;

  public Contact() {

  }

  public int getContactId() {
    return contactId;
  }

  public void setContactId(int contactId) {
    this.contactId = contactId;
  }

  public String getContactNum() {
    return contactNum;
  }

  public void setContactNum(String contactNum) {
    this.contactNum = contactNum;
  }

  public Contact(int contactId, String contactNum) {
    this.setContactId(contactId);
    this.setContactNum(contactNum);

  }


}
