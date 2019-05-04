package com.xiaofeng.plus.exampleTest.controller;


import com.xiaofeng.plus.exampleTest.entity.ExampleTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-02
 */
@RestController
@RequestMapping("/exampleTest/exampleTest")
public class ExampleTestController {

    @PostMapping("/save")
    public ExampleTest save(@RequestBody ExampleTest exampleTest){
        exampleTest.insert();
        return exampleTest;
    }
}
