package com.bdqn.bills.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.bills.entity.Bills;
import com.bdqn.bills.service.BillsService;
import com.bdqn.bills.utils.DataGridViewResult;
import com.bdqn.bills.vo.BillsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
@Controller
@RequestMapping("/bills")
public class BillsController {

    @Resource
    private BillsService billsService;

    /**
     * 去到账单列表页面
     * @return
     */
    @GetMapping("/toBillList")
    public String toBillList(){
        return "billList";
    }


    @ResponseBody
    @RequestMapping("/list")
    public DataGridViewResult list(BillsVo billsVo){
        //创建分页对象
        IPage<Bills> page = new Page<Bills>(billsVo.getPage(),billsVo.getLimit());
        try {
            //调用查询的方法
            billsService.findBillListByPage(page,billsVo);
            //返回数据
            return new DataGridViewResult(page.getTotal(),page.getRecords());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//暂无数据
    }


    /**
     * 添加账单
     * @param bills
     * @return
     */
    @ResponseBody
    @PostMapping("/addBill")
    public String addBill(Bills bills){
        Map<String,Object> map = new HashMap<String,Object>();
        if(billsService.save(bills)){
            map.put("success",true);
            map.put("message","账单添加成功");
        }else{
            map.put("success",false);
            map.put("message","账单添加失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 修改账单
     * @param bills
     * @return
     */
    @ResponseBody
    @PostMapping("/updateBill")
    public String updateBill(Bills bills){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用根据主键修改的方法
        if(billsService.updateById(bills)){
            map.put("success",true);
            map.put("message","账单修改成功");
        }else{
            map.put("success",false);
            map.put("message","账单修改失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除账单
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用根据ID删除的方法
        if(billsService.removeById(id)){
            map.put("success",true);
            map.put("message","账单删除成功");
        }else{
            map.put("success",false);
            map.put("message","账单删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 批量删除账单
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/batchDelete")
    public String batchDelete(String ids){
        Map<String,Object> map = new HashMap<String,Object>();
        //将字符串拆分成数组
        String [] idsArr = ids.split(",");
        //调用根据ID批量删除的方法
        if(billsService.removeByIds(Arrays.asList(idsArr))){
            map.put("success",true);
            map.put("message","账单删除成功");
        }else{
            map.put("success",false);
            map.put("message","账单删除失败");
        }
        return JSON.toJSONString(map);
    }




}

