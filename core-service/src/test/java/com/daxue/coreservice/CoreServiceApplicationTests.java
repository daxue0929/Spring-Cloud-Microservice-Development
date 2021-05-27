package com.daxue.coreservice;


import com.daxue.coreservice.temp.entity.Account;
import com.daxue.coreservice.temp.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.daxue.coreservice.utils.StatusEntity.VALID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoreServiceApplicationTests {

    @Autowired
    private IAccountService accountService;


    @Test
    public void contextLoads() {
    }


    @Test
    public void selectUser() {
        Account accountMock = new Account();
        accountMock.setUsername("daxue").setPassword("daxue").setStatus(VALID);
        accountService.save(accountMock);
        List<Account> list = accountService.list();
    }

}
