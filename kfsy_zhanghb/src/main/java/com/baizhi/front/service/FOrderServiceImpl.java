package com.baizhi.front.service;

import com.baizhi.common.entity.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FOrderServiceImpl implements FOrderService{
    @Override
    public void addOreder(Address address, String userid) {

    }
}
