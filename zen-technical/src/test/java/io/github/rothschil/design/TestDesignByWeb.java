package io.github.rothschil.design;

<<<<<<< HEAD
import io.github.rothschil.BaseTest;
=======
import io.github.rothschil.BaseAppTest;
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be
import io.github.rothschil.design.observer.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.rothschil.design.observer.async.BrcService;

@DisplayName("设计模式-Web")
@Slf4j
<<<<<<< HEAD
public class TestDesignByWeb extends BaseTest {
=======
public class TestDesignByWeb extends BaseAppTest {
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be

    @Autowired
    private BrcService brcService;

    @DisplayName("观察者模式-异步")
    @Test
    public void testObserver() {
        Article article1 = new Article("富豪","怎么成为富豪","");
        brcService.brcToBlog("Sam.Von.Abram",article1);
    }
}
