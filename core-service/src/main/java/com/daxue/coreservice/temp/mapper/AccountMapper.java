package com.daxue.coreservice.temp.mapper;

import com.daxue.coreservice.temp.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author daxue0929
 * @since 2021-05-27
 */
@Mapper
@Repository
public interface AccountMapper extends BaseMapper<Account> {

}
