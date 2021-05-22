package com.daxue.idservice.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Service;

/**
 * @author daxue0929
 * @date 2021/05/23
 **/
@Slf4j
@Service
public class GenerateIdService {

    //因为二进制第一个 bit 为如果是1,那么都是负数,但我们生成的 id 都是正数, 所以第一个bit 统一都是0

    // 机器ID 2进制5位 32位减掉1位 31个
    private long workerId;

    // 机房ID 2进制5位 32位减掉1位 31个
    private long datacenterId;

    // 代表一毫秒内生成的多个id的最新序号, 12位 4096
    private long sequence;

    //设置一个时间初始值 2^41-1 差不多可以用69年
    private long twepoct = 1585644268888L;

    //5位的机器id
    private long workerIdBits = 5L;

    //5位的机房id
    private long datacenterIdBits = 5L;

    //每毫秒内产生的id数 2的12次方
    private long sequenceBits = 12L;

    // 这个是二进制运算,就是5个bit最多只能有31个数字,也就是说机器id最多只能32个以内
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);

    // 这个是一个意思,就是5个bit最多只能有31个数字,也就是说机房id最多只能32个以内
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    //记录产生时间毫秒数,判断是否是同一秒
    private long lastTimestamp = -1L;

    public long getWorkerId(){
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    public GenerateIdService generateId(long workerId, long datacenterId, long sequence) throws IllegalAccessException {
        //检查机房id和机器id是否大于31, 不能小于0
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalAccessException(String.format("worker Id 不能超过%d,并且不能小于0", maxWorkerId));
        }

        //检查机房id
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalAccessException(String.format("datacenterId 不能超过%d,并且不能小于0", maxDatacenterId));
        }

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;

        return this;
    }

     public synchronized long nextId() throws IllegalAccessException {
        // 这就是获取的当前时间戳,单位毫秒
         long timestamp = timeGen();
         if (timestamp < lastTimestamp) {
             System.err.printf("Clock is moving backwards, Rejecting requests until %d", lastTimestamp);
             throw new IllegalAccessException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
         }

         //下面是说假设在同一毫秒内,又发送了一个请求生成一个id
         //这个时候就把sequence序号给递增1, 最多就是4096

         if (lastTimestamp == timestamp) {

             // 这个意思说说一个毫秒只能有4096个数字,无论你传递多少进来
             // 这个位运算保证始终在4096这个范围内,避免你自己传递个sequence超过了4096这个范围
             sequence = (sequence + 1) & sequenceMask;

             if (sequence == 0) {
                 timestamp = tilNextMillis(lastTimestamp);
             }
         }else {
             sequence = 0;
         }

         // 这里记录一下最近一次生成id的时间戳,单位事毫秒
         lastTimestamp = timestamp;

         //这儿就是最核心的二进制位运算操作,生成一个64bit的id
         //先将当前时间戳左移,房贷41bit 那儿, 将机房id左移5bit那儿,将机器id放到5bit那儿,将序号放最后12bit
         //最后拼接成一个64 bit的二进制数,转换成10进制就是个long型

         return (timestamp - twepoct) << timestampLeftShift |
                 (datacenterId << datacenterIdShift) |
                 (workerId << workerIdShift) | sequence;
     }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }

    // ..todo 这两个关键方法还是有问题的,需要修改一下.
    @Test
    public void test() throws IllegalAccessException {
        System.out.println(1 & 4596);
        System.out.println(2 & 4596);
        System.out.println(3 & 4596);
        System.out.println(4 & 4596);
        System.out.println(5 & 4596);
        System.out.println(6 & 4596);
        generateId(1, 1, 1);
        for (int i = 0; i < 22; i++) {
            long l = nextId();
            System.out.println(l);
        }

    }

}
