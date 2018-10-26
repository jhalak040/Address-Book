package com.axelor.address.book.service;

import com.axelor.address.book.db.Address;

public interface AddressService {

  public void insertAddress(Address address);

  public Address getAddressById(int addressId);

  public void updateAddress(Address address);

  public void deleteAddress(int addressId);

}
