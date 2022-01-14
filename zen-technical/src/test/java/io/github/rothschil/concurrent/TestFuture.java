package io.github.rothschil.concurrent;

import io.github.rothschil.concurrent.future.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("设计模式")
@Slf4j
public class TestFuture {


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

    @Test
    public void testSync(){
        List<String> prices = ShopService.findPriceSync("Thinkpad");
        prices.stream().forEach((price)->log.warn(price));
    }

    @Test
    public void testCompletableFuture(){
        List<String> prices = ShopService.findPriceAsync("Thinkpad");
        prices.stream().forEach((price)->log.warn(price));
    }
}
