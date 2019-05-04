package com.xiaofeng.plus.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeng.plus.base.PageDto;
import com.xiaofeng.plus.base.PageVo;
import com.xiaofeng.plus.example.entity.Collect;
import com.xiaofeng.plus.example.service.ICollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-01
 */
@RestController
@RequestMapping("/example/collect")
@Api(value = "collect", tags = "collect_tags")
public class CollectController {

    @Autowired
    private ICollectService iCollectService;


    @ApiOperation("保存")
    @PostMapping("/save")
    public Collect save(@RequestBody Collect collect){
//        iCollectService.save(collect);
        // AR
        collect.insert();
        return collect;
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Collect update(@RequestBody Collect collect){
        iCollectService.updateById(collect);
        return collect;
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", required = true, paramType = "Long")
    )
    public boolean delete(Long id){
        return iCollectService.removeById(id);
    }

    @ApiOperation("查询所有")
    @PostMapping("/list")
    public List<Collect> list(){
        return iCollectService.list();
    }

    @ApiOperation("查询id单个")
    @PostMapping("/get")
    public Collect get(Long id){
        return iCollectService.getById(id);
    }

    @ApiOperation("条件查询")
    @PostMapping("/listByCollect")
    public List<Collect> listByCollect(@RequestBody Collect collect){
        return iCollectService.list(new QueryWrapper<Collect>(collect));
    }

    @ApiOperation("分页查询")
    @PostMapping("page")
    public IPage<Collect> page(PageDto pageDto){
        Page<Collect> collectPage = new Page<>(pageDto.getCurrent(), pageDto.getSize());
        return iCollectService.page(collectPage);
    }

    @ApiOperation("自定义SQL分页查询")
    @PostMapping
    public PageVo<Collect> sqlPage(@RequestBody PageDto pageDto, Short deleteType){
        Page<Collect> page = new Page<>(pageDto.getCurrent(), pageDto.getSize());
        iCollectService.sqlPage(page, deleteType);
        return JSON.parseObject(JSON.toJSONString(page), new TypeReference<PageVo<Collect>>(){});
    }


}
