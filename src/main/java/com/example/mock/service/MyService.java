package com.example.mock.service;

import com.example.mock.model.MyEntity;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public MyEntity checkEntity(MyEntity myEntity) {
        return myEntity;
    }

    public MyEntity getNewEntity() {
        return new MyEntity();
    }
}
