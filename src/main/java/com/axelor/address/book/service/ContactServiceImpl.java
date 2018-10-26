package com.axelor.address.book.service;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import com.axelor.address.book.db.Contact;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class ContactServiceImpl implements ContactService {

  @Inject
  Provider<EntityManager> emp;

  @Override
  @Transactional
  public void insertContact(Contact contact) {
    EntityManager em = emp.get();
    em.merge(contact);
  }

  @Override
  @Transactional
  public void updateContact(Contact contact) {
    EntityManager em = emp.get();
    em.merge(contact);
  }

  @Override
  @Transactional
  public Contact getContactById(int StudentId) {
    EntityManager em = emp.get();
    return em.find(Contact.class, StudentId);
  }

  @Override
  @Transactional
  public void deleteByContact(int contactId) {
    EntityManager em = emp.get();
    Contact c = em.find(Contact.class, contactId);
    em.remove(c);
  }

}
