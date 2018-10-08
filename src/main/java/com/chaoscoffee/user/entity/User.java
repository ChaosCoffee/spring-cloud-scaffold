package com.chaoscoffee.user.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.chaoscoffee.dao.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chaoscoffee
 * @since 2018-10-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userCode;

    private String name;

    private BigDecimal totalAmount;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
