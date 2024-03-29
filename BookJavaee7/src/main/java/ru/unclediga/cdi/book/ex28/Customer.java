package ru.unclediga.cdi.book.ex28;

/*
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
*/
import java.util.Date;

//import static javax.persistence.TemporalType.DATE;

// @Entity
public class Customer {

  // ======================================
  // =             Attributes             =
  // ======================================

//  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
//  @Temporal(DATE)
  private Date dateOfBirth;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String toString(){
    return "Customer(" + firstName + ":" + lastName + ":" + email + ")";
  }
}