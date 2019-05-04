package com.xiaofeng.plus.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Auther: 晓枫
 * @Date: 2019/5/2 08:31
 * @Description:
 */
@ApiModel("出参分页模型")
@Data
@Accessors(chain = true)
public class PageVo<T> {
    @ApiModelProperty("记录数")
    private List<T> records;
    @ApiModelProperty("总条数")
    private long total;
    @ApiModelProperty("每页大小")
    private long size;
    @ApiModelProperty("当前页")
    private long current;
}
