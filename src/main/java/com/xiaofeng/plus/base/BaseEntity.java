package com.xiaofeng.plus.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: 晓枫
 * @Date: 2019/5/1 10:28
 * @Description:
 */
@Data
@Accessors(chain = true)
public class BaseEntity<T> extends Model<BaseEntity> implements Serializable {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
}
