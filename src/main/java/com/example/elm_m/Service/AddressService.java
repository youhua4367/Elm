package com.example.elm_m.Service;

import com.example.elm_m.Entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> list();

    void save(Address address);

    Address getById(Long id);

    void update(Address address);

    void setDefault(Address address);

    void delete(Long id);

    Address getDefault();
}
