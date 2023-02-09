package com.stk.stk_sale.service.impl;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stk.stk_sale.config.HttpClint;
import com.stk.stk_sale.model.alldata.AllSale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 定时任务
 *
 */
@Component
@Slf4j
public class NotifyTaskImpl implements CommandLineRunner {

    @Autowired
    private SaleServiceImpl saleService;
    @Autowired
    private PurchServiceImpl purchService;


    /**
     * 获取最新的订单数据。
     *
     *定时运行 每隔10分钟运行一次
     */
    @Scheduled(cron = "0 */10 * * * ?")
    public void s_notify() {
        saleService.save();
        purchService.save();
    }

    /**
     * 启动后立刻运行
     */

    @Override
    public void run(String... args) throws Exception {
        saleService.save();
        purchService.save();
    }
}
