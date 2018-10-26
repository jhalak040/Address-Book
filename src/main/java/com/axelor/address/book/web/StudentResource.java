package com.axelor.address.book.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import com.axelor.address.book.db.Address;
import com.axelor.address.book.db.Contact;
import com.axelor.address.book.db.Student;
import com.axelor.address.book.service.AddressService;
import com.axelor.address.book.service.ContactService;
import com.axelor.address.book.service.StudentService;
import com.google.inject.Inject;

@Path("/")
public class StudentResource {

  @Inject
  private StudentService studentservice;
  @Inject
  private AddressService addressService;
  @Inject
  private ContactService contactService;

  @POST
  @Path("/insert")
  public void insertStudent(@PathParam("id") String studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws IOException, ServletException {

    Student student = new Student();
    student.setFirstName(request.getParameter("firstName"));
    student.setLastName(request.getParameter("lastName"));
    List<Contact> contactList = new ArrayList<>();
    String[] contactNums = request.getParameterValues("contactNum");
    for (int i = 0; i < contactNums.length; i++) {
      Contact contact = new Contact();
      contact.setContactNum(contactNums[i]);
      contact.setStudent(student);
      // contactinterface.insertContact(contact);
      contactList.add(contact);
    }
    student.setContactlist(contactList);
    List<Address> addressList = new ArrayList<>();
    // String[] addressId = request.getParameterValues("addId");
    String[] buildingNames = request.getParameterValues("buildingName");
    String[] flatNums = request.getParameterValues("flatNum");
    String[] streetNames = request.getParameterValues("streetName");
    String[] citys = request.getParameterValues("city");
    String[] pincodes = request.getParameterValues("pincode");
    String[] states = request.getParameterValues("state");

    for (int j = 0; j < buildingNames.length; j++) {
      Address address = new Address();
      address.setBuildingName(buildingNames[j]);
      address.setFlatNum(flatNums[j]);
      address.setStreetName(streetNames[j]);
      address.setCity(citys[j]);
      address.setPincode(pincodes[j]);
      address.setState(states[j]);
      address.setStudent(student);
      addressList.add(address);
    }
    student.setAddresslist(addressList);
    studentservice.insertStudent(student);
    response.sendRedirect(request.getContextPath());
  }

  @GET
  @Path("/delete/{id}")
  public void deleteStudent(@PathParam("id") int studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {
    studentservice.deleteStudent(studId);
    response.sendRedirect(request.getContextPath());
  }

  @DELETE
  @Path("/delete/{id}")
  public void deleteStudent1(@PathParam("id") int studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {
    studentservice.deleteStudent(studId);
    response.sendRedirect(request.getContextPath());
  }

  @GET
  public List<Student> getAllStudent(@Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {
    List<Student> student = studentservice.getAllStudent();
    request.setAttribute("StudentList", student);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
    return student;
  }

  @GET
  @Path("/getStudent/{id}")
  public void getStudentById(@PathParam("id") String studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {
    Student student = studentservice.getStudentById(Integer.parseInt(studId));
    request.setAttribute("student", student);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
    dispatcher.forward(request, response);
  }

  @POST
  @Path("/update/{id}")
  public void updateStudent(@PathParam("id") int studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {

    Student student = studentservice.getStudentById(studId);
    student.setFirstName(request.getParameter("firstName"));
    student.setLastName(request.getParameter("lastName"));
    List<Contact> contactList = student.getContactlist();
    String[] contIds = request.getParameterValues("contId");
    String[] contactNums = request.getParameterValues("contactNum");

    for (int i = 0; i < contIds.length; i++) {
      Contact contact = contactService.getContactById(Integer.parseInt(contIds[i]));
      contactList.remove(contact);
      contact.setContactNum(contactNums[i]);
      // contact.setStudent(student);
      contactService.updateContact(contact);
      contactList.add(contact);
    }
    student.setContactlist(contactList);
    List<Address> addressList = student.getAddresslist();
    String[] addIds = request.getParameterValues("addId");
    String[] buildingNames = request.getParameterValues("buildingName");
    String[] flatNums = request.getParameterValues("flatNum");
    String[] streetNames = request.getParameterValues("streetName");
    String[] citys = request.getParameterValues("city");
    String[] pincodes = request.getParameterValues("pincode");
    String[] states = request.getParameterValues("state");

    for (int j = 0; j < addIds.length; j++) {
      Address address = addressService.getAddressById(Integer.parseInt(addIds[j]));
      addressList.remove(address);
      address.setBuildingName(buildingNames[j]);
      address.setFlatNum(flatNums[j]);
      address.setStreetName(streetNames[j]);
      address.setCity(citys[j]);
      address.setPincode(pincodes[j]);
      address.setState(states[j]);
      addressService.updateAddress(address);
      addressList.add(address);
    }
    student.setAddresslist(addressList);
    response.sendRedirect(request.getContextPath());
  }

  @POST
  @Path("/student/{id}")
  public void getStudentById1(@PathParam("id") String studentId,
      @Context HttpServletRequest request, @Context HttpServletResponse response)
      throws ServletException, IOException {
    Student student =
        studentservice.getStudentById(Integer.parseInt(request.getParameter("studentId")));
    request.setAttribute("StudentList", new ArrayList<Student>(Arrays.asList(student)));
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
    // response.sendRedirect(request.getContextPath()+"/index.jsp");
  }

  @POST
  @Path("/searchname")
  public void searchStudent(@PathParam("namesearch") String namesearch,
      @Context HttpServletRequest request, @Context HttpServletResponse response)
      throws IOException {
    List<Student> student = studentservice.searchStudent(request.getParameter("namesearch"));
    request.setAttribute("StudentList", student);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GET
  @Path("/getaddress/{id}")
  public void getAddress(@PathParam("id") String studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {

    Student student = studentservice.getStudentById(Integer.parseInt(studId));
    List<Address> addList = student.getAddresslist();
    Address address = addressService.getAddressById(addList.get(0).getAddressId());
    request.setAttribute("student", student);
    request.setAttribute("address", address);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/insertaddress.jsp");
    dispatcher.forward(request, response);
  }

  @POST
  @Path("/add/{id}")
  public void addAddress(@PathParam("id") String studId, @PathParam("id") String addId,
      @Context HttpServletRequest request, @Context HttpServletResponse response)
      throws ServletException, IOException {

    Student student = studentservice.getStudentById(Integer.parseInt(studId));
    Address address = new Address();
    address.setBuildingName(request.getParameter("buildingName"));
    address.setFlatNum(request.getParameter("flatNum"));
    address.setStreetName(request.getParameter("streetName"));
    address.setCity(request.getParameter("city"));
    address.setPincode(request.getParameter("pincode"));
    address.setState(request.getParameter("state"));
    List<Address> addressList = student.getAddresslist();
    addressList.add(address);
    student.setAddresslist(addressList);
    address.setStudent(student);
    // addressInterface.insertAddress(address);
    studentservice.updateStudent(student);
    response.sendRedirect(request.getContextPath());
  }

  @GET
  @Path("/getcontact/{id}")
  public void getcontact(@PathParam("id") String studId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {

    Student student = studentservice.getStudentById(Integer.parseInt(studId));
    List<Contact> contList = student.getContactlist();
    Contact contact = contactService.getContactById(contList.get(0).getContactId());
    request.setAttribute("student", student);
    request.setAttribute("Contact", contact);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/insertcontact.jsp");
    dispatcher.forward(request, response);
  }

  @POST
  @Path("/addcontact/{id}")
  public void addContact(@PathParam("id") String studId, @PathParam("id") String contId,
      @Context HttpServletRequest request, @Context HttpServletResponse response)
      throws IOException {

    Student student = studentservice.getStudentById(Integer.parseInt(studId));
    Contact contact = new Contact();
    contact.setContactNum(request.getParameter("contactNum"));
    List<Contact> contactList = student.getContactlist();
    contactList.add(contact);
    student.setContactlist(contactList);
    contact.setStudent(student);
    studentservice.updateStudent(student);
    response.sendRedirect(request.getContextPath());
  }

  @GET
  @Path("/deletecontact/{id}")
  public void deleteByContact(@PathParam("id") int contId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws ServletException, IOException {
    Contact con = contactService.getContactById(contId);
    Student student = con.getStudent();
    contactService.deleteByContact(contId);
    List<Contact> conList = student.getContactlist(); // understandable
    conList.remove(con);
    student.setContactlist(conList);
    studentservice.updateStudent(student);
    response.sendRedirect(request.getContextPath());
  }

  @GET
  @Path("/delecteaddress/{id}")
  public void deleteByAddress(@PathParam("id") int addId, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws IOException {
    
    Address address = addressService.getAddressById(addId);
    Student student = address.getStudent();
    addressService.deleteAddress(addId);
    List<Address> addressList = student.getAddresslist();
    addressList.remove(address);
    student.setAddresslist(addressList);
    studentservice.updateStudent(student);
    response.sendRedirect(request.getContextPath());
  }
}


