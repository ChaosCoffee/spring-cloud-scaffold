package com.chaoscoffee.entity;

import com.chaoscoffee.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    private Long userCode;

    private String name;

    private BigDecimal totalAmount;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "User{" +
                "userCode=" + userCode +
                ", name='" + name + '\'' +
                ", totalAmount=" + totalAmount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                '}';
    }
}
