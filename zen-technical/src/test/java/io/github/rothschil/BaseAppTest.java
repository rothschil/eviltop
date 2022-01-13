package io.github.rothschil;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BaseAppTest {

    long beginTime;
    long end;

    @BeforeEach
    public void before(){
        beginTime = System.currentTimeMillis();
    }

    @AfterEach
    public void after(){
        end = System.currentTimeMillis();
    }

    @AfterEach
    public void afterAll(){
        log.info("[AfterAll] Time consuming={} ms",(end-beginTime));
    }
}
