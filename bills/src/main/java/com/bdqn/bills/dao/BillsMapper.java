package com.bdqn.bills.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdqn.bills.entity.Bills;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.bills.vo.BillsVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
public interface BillsMapper extends BaseMapper<Bills> {

    /**
     * 分页查询账单信息
     * @param page
     * @param bills
     * @return
     * @throws Exception
     */
    IPage<Bills> findBillListByPage(@Param("page") IPage<Bills> page,@Param("bills") BillsVo bills)  throws Exception;
}
