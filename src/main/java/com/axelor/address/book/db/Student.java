package com.axelor.address.book.db;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.axelor.address.book.db.Address;
import com.axelor.address.book.db.Contact;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int studentId;

  private String firstName;

  private String lastName;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Address> addresslist;

  public List<Address> getAddresslist() {
    return addresslist;
  }

  public void setAddresslist(List<Address> addresslist) {
    this.addresslist = addresslist;
  }

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Contact> contactlist;

  public List<Contact> getContactlist() {
    return contactlist;
  }

  public void setContactlist(List<Contact> contactlist) {
    this.contactlist = contactlist;
  }

  public Student() {

  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Student(int studentId, String firstName, String lastName) {
    this.setStudentId(studentId);
    this.setFirstName(firstName);
    this.setLastName(lastName);
  }

}

