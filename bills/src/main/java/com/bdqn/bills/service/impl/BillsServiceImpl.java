package com.bdqn.bills.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdqn.bills.entity.Bills;
import com.bdqn.bills.dao.BillsMapper;
import com.bdqn.bills.service.BillsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.bills.vo.BillsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
@Service
@Transactional
public class BillsServiceImpl extends ServiceImpl<BillsMapper, Bills> implements BillsService {

    @Resource
    private BillsMapper billsMapper;

    @Override
    public IPage<Bills> findBillListByPage(IPage<Bills> page, BillsVo bills) throws Exception {
        return billsMapper.findBillListByPage(page,bills);
    }
}
