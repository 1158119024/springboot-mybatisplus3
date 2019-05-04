package com.xiaofeng.plus.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: 晓枫
 * @Date: 2019/5/2 08:27
 * @Description:
 */
@ApiModel("入参分页模型")
@Data
@Accessors(chain = true)
public class PageDto {
    @ApiModelProperty("当前页")
    private long current;
    @ApiModelProperty("每页大小")
    private long size;
}
