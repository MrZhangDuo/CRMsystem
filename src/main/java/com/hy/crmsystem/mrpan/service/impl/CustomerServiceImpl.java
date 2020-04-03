package com.hy.crmsystem.mrpan.service.impl;

import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrpan.mapper.CustomerMapper;
import com.hy.crmsystem.mrpan.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
