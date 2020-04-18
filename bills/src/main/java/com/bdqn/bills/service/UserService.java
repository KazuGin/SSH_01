package com.bdqn.bills.service;

import com.bdqn.bills.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param user
     * @return
     * @throws Exception
     */
    User login(User user) throws Exception;
}
