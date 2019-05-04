package com.xiaofeng.plus.example.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiaofeng.enums.GenderEnum;
import com.xiaofeng.plus.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("example_collect")
public class Collect extends BaseEntity<Collect> {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String title;

    private String url;

    private GenderEnum gender;


    @TableLogic
    private Short deleteType;

}
