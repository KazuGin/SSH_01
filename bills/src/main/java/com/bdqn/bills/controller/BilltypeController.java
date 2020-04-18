package com.bdqn.bills.controller;


import com.bdqn.bills.service.BilltypeService;
import com.bdqn.bills.utils.DataGridViewResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
@RestController
@RequestMapping("/billtype")
public class BilltypeController {

    @Resource
    private BilltypeService billtypeService;

    /**
     * 查询所有账单类型
     * @return
     */
    @RequestMapping("/findAll")
    public DataGridViewResult findAll(){
        return new DataGridViewResult(billtypeService.list());
    }

}

