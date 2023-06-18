package com.example.mock.service;

import com.example.mock.model.MyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final MyService myService;

    public MyEntity checkEntity(MyEntity myEntity) {
        myService.checkEntity(myEntity);
        return myEntity;
    }

    public MyEntity getNewEntity() {
        return myService.getNewEntity();
    }
}
