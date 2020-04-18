package com.bdqn.bills.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdqn.bills.entity.User;
import com.bdqn.bills.dao.UserMapper;
import com.bdqn.bills.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.bills.utils.PasswordUtil;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) throws Exception {
        //创建条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("loginname",user.getLoginname());
        queryWrapper.eq("pwd", PasswordUtil.md5(user.getPwd(),user.getLoginname(),3));
        return  userMapper.selectOne(queryWrapper);
    }
}
