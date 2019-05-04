package com.xiaofeng.plus.example.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeng.plus.example.entity.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-01
 */
public interface CollectMapper extends BaseMapper<Collect> {


    Page<Collect> sqlPage(Page page,@Param("deleteType") Short deleteType);

    Page<Collect> sqlPage2(Page page);

    List<Collect> sqlList();
}
