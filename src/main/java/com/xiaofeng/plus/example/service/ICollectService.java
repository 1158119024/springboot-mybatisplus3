package com.xiaofeng.plus.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeng.plus.example.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-01
 */
public interface ICollectService extends IService<Collect> {


    Page<Collect> sqlPage(Page page, Short deleteType);
    Page<Collect> sqlPage2(Page page);

    List<Collect> sqlList();
}
