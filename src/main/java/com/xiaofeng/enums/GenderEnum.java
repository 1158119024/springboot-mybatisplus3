package com.xiaofeng.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @Auther: 晓枫
 * @Date: 2019/5/1 12:21
 * @Description:
 */
public enum GenderEnum {
    man(1, "男"),
    woman(2, "女");

    @EnumValue//标记数据库存的值是code
    private final int gender;
    private final String desc;

    GenderEnum(int gender, String desc) {
        this.gender = gender;
        this.desc = desc;
    }
    public int getGender() {
        return gender;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return getDesc();
    }
}
