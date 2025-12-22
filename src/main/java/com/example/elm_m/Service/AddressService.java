package com.example.elm_m.Service;

import com.example.elm_m.Entity.Address;
import com.example.elm_m.Entity.AddressResponse;
import com.example.elm_m.VO.AddressVO;

import java.util.List;

public interface AddressService {

    List<Address> list();

    void save(Address address);

    Address getById(Long id);

    void update(Address address);

    void setDefault(Address address);

    void delete(Long id);

    Address getDefault();

    AddressVO getAddress(String position);
}
