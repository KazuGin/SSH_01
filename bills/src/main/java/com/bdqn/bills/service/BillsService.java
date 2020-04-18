package com.bdqn.bills.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.bills.entity.Bills;
import com.bdqn.bills.vo.BillsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
public interface BillsService extends IService<Bills> {
    /**
     * 分页查询账单信息
     * @param page
     * @param bills
     * @return
     * @throws Exception
     */
    IPage<Bills> findBillListByPage(IPage<Bills> page, BillsVo bills)  throws Exception;
}
