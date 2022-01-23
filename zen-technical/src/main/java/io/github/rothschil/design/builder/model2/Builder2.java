package io.github.rothschil.design.builder.model2;

import io.github.rothschil.design.builder.Car;

/** 工种
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2022/1/14 - 14:17
 * @since 1.0.0
 */
public interface Builder2 {

    Builder2 engine();

    Builder2 tires();

    Builder2 chassis();

    Builder2 transmission();

    Builder2 electrical();

    Car build();
}
