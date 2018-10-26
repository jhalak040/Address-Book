package com.axelor.address.book.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.axelor.address.book.db.Student;

@Entity
public class Address {

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
  private int addressId;

  @Column(name = "Building_Name")
  private String buildingName;

  @Column(name = "FlatNum")
  private String flatNum;

  @Column(name = "streetName")
  private String streetName;

  @Column(name = "city")
  private String city;

  @Column(name = "State")
  private String state;

  @Column(name = "Pincode")
  private String pincode;

  public int getAddressId() {
    return addressId;
  }

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  public String getBuildingName() {
    return buildingName;
  }

  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public String getFlatNum() {
    return flatNum;
  }

  public void setFlatNum(String flatNum) {
    this.flatNum = flatNum;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }
}
