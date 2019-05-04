package com.xiaofeng.plus.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeng.plus.example.entity.Collect;
import com.xiaofeng.plus.example.mapper.CollectMapper;
import com.xiaofeng.plus.example.service.ICollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-01
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    @Resource
    private CollectMapper collectMapper;

    @Override
    public Page<Collect> sqlPage(Page page, Short deleteType) {
        return collectMapper.sqlPage(page, deleteType);
    }

    @Override
    public Page<Collect> sqlPage2(Page page) {
        return collectMapper.sqlPage2(page);
    }

    @Override
    public List<Collect> sqlList() {
        return collectMapper.sqlList();
    }
}
