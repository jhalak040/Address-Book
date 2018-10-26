package com.axelor.address.book.service;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import com.axelor.address.book.db.Address;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class AddressServiceImpl implements AddressService {
  @Inject
  Provider<EntityManager> emp;

  @Override
  @Transactional
  public void insertAddress(Address address) {
    EntityManager em = emp.get();
    em.merge(address);
  }
  /*
   * ERROR:
   * 
   * em.persist(address); javax.persistence.PersistenceException:
   * org.hibernate.PersistentObjectException: detached entity passed to persist:
   * com.axelor.addressfield.Address
   * 
   * 
   */

  @Override
  @Transactional
  public void updateAddress(Address address) {
    EntityManager em = emp.get();
    em.merge(address);

  }

  @Override
  @Transactional
  public Address getAddressById(int studentId) {
    EntityManager em = emp.get();
    return em.find(Address.class, studentId);

  }

  @Override
  @Transactional
  public void deleteAddress(int addressId) {
    EntityManager em = emp.get();
    Address a = em.find(Address.class, addressId);
    em.remove(a);

  }
}
