package com.example.elm_m.Service.Impl;

import com.example.elm_m.Constant.MessageConstant;
import com.example.elm_m.Context.ThreadContext;
import com.example.elm_m.Entity.Address;
import com.example.elm_m.Entity.AddressResponse;
import com.example.elm_m.Exception.ApiException;
import com.example.elm_m.Mapper.AddressMapper;
import com.example.elm_m.Properties.MapProperties;
import com.example.elm_m.Service.AddressService;
import com.example.elm_m.VO.AddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MapProperties mapProperties;

    /**
     * 获取地址信息
     * @return 地址列表
     */
    @Override
    public List<Address> list() {
        String userId = ThreadContext.getCurrentId();

        return addressMapper.getByUserId(userId);
    }

    /**
     * 新增地址
     * @param address 地址实体
     */
    @Override
    public void save(Address address) {
        address.setUserId(ThreadContext.getCurrentId());
        address.setIsDefault(1);
        addressMapper.insert(address);
    }

    /**
     * 根据 id 获得地址
     * @param id 地址id
     * @return 地址
     */
    @Override
    public Address getById(Long id) {
        return addressMapper.getByAddressId(id);
    }

    /**
     * 修改地址
     * @param address 地址
     */
    @Override
    public void update(Address address) {
        addressMapper.update(address);
    }

    /**
     * 修改默认地址
     * @param address 地址参数
     */
    @Override
    @Transactional
    public void setDefault(Address address) {
        // 将用户所有地址修改为非默认地址 0
        Address address1 = new Address();
        address1.setUserId(ThreadContext.getCurrentId());
        address1.setIsDefault(0);

        addressMapper.updateIsDefaultByUserId(address1);

        // 将 address 的地址设置为 1
        address.setIsDefault(1);
        addressMapper.update(address);
    }

    /**
     * 删除地址
     * @param id 地址id
     */
    @Override
    public void delete(Long id) {
        addressMapper.deleteById(id);
    }

    /**
     * 查询默认地址
     * @return 默认地址实体
     */
    @Override
    public Address getDefault() {
        Address address = new Address();
        address.setUserId(ThreadContext.getCurrentId());
        address.setIsDefault(1);

        return addressMapper.getDefault(address);
    }

    /**
     * 获取高德地图位置
     * @return 位置
     */
    @Override
    public AddressVO getAddress(String position) {

        String key = mapProperties.getMapKey();

        String url = "https://restapi.amap.com/v3/geocode/regeo"
                + "?output=json"
                + "&location=" + position
                + "&key=" + key
                + "&radius=100"
                + "&extensions=base";

        AddressResponse response = restTemplate.getForObject(url, AddressResponse.class);

        if (response != null && !response.getStatus().equals("1")) {
            throw new ApiException(MessageConstant.API_ERROR);
        }

        if (response != null) {
            return AddressVO.builder()
                    .address(response.getRegeocode().getFormatted_address())
                    .build();
        }
        return null;
    }


}
