package com.hy.crmsystem.service.impl;

import com.hy.crmsystem.entity.Customer;
import com.hy.crmsystem.mapper.CustomerMapper;
import com.hy.crmsystem.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
