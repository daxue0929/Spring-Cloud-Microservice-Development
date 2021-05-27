package com.daxue.coreservice.temp.service.impl;

import com.daxue.coreservice.temp.entity.Account;
import com.daxue.coreservice.temp.mapper.AccountMapper;
import com.daxue.coreservice.temp.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author daxue0929
 * @since 2021-05-27
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
