package com.example.mock;

import com.example.mock.model.MyEntity;
import com.example.mock.service.MyService;
import com.example.mock.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MockApplication.class)
@ExtendWith(SpringExtension.class)
class ServiceTests {

    private final MyService myService = mock();
    private final TestService testService = new TestService(myService);

    @Test
    void contextLoads() {
        final MyEntity testEntity = new MyEntity();
        testEntity.setId(1L);

        when(myService.checkEntity(argThat(entity -> entity.getId().equals(1L))))
                .thenThrow(new RuntimeException("This is an error"));
        Assertions.assertThrows(RuntimeException.class, () -> testService.checkEntity(testEntity));
    }
}
