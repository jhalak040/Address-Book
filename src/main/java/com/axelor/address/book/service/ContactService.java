package com.axelor.address.book.service;

import com.axelor.address.book.db.Contact;

public interface ContactService {

  public void insertContact(Contact contact);

  public void updateContact(Contact contact);

  public Contact getContactById(int contactId);

  public void deleteByContact(int contId);
}
