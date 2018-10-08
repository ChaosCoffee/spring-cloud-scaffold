package com.chaoscoffee.entity.base;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chaoscoffee
 * @date 2018/10/8
 * @description
 */
@Data
public class BaseEntity<T extends Model> extends Model<T> {

    @TableId
    protected Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
