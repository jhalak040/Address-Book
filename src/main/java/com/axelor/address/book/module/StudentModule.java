package com.axelor.address.book.module;

import com.axelor.address.book.service.AddressService;
import com.axelor.address.book.service.AddressServiceImpl;
import com.axelor.address.book.service.ContactService;
import com.axelor.address.book.service.ContactServiceImpl;
import com.axelor.address.book.service.StudentService;
import com.axelor.address.book.service.StudentServiceImpl;
import com.axelor.address.book.web.StudentResource;
import com.google.inject.AbstractModule;

public class StudentModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(StudentResource.class);
    bind(StudentService.class).to(StudentServiceImpl.class);
    bind(AddressService.class).to(AddressServiceImpl.class);
    bind(ContactService.class).to(ContactServiceImpl.class);
  }
}
