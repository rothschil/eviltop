package io.github.rothschil.domain.entity;

import io.github.rothschil.common.po.BasePo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *
 *
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2021/10/21 - 12:19
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Order extends BasePo<Integer> {

    @NotNull(message = "参数orderId不能为空")
    private Integer id;

    @NotNull(message = "参数price不能为空")
    private BigDecimal price;

    @NotNull(message = "参数userId不能为空")
    private Integer userId;

    @NotBlank(message = "参数status不能为空")
    private String status;

}
