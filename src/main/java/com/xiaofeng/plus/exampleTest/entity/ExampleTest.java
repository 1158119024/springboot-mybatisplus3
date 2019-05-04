package com.xiaofeng.plus.exampleTest.entity;

import com.xiaofeng.plus.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ExampleTest对象", description="")
public class ExampleTest extends BaseEntity<ExampleTest> {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String password;


}
