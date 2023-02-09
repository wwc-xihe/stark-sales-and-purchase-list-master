package com.stk.stk_sale;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stk.stk_sale.config.HttpClint;
import com.stk.stk_sale.mapper.PurchMapper;
import com.stk.stk_sale.model.StkPurchData;
import com.stk.stk_sale.model.StkSaleData;
import com.stk.stk_sale.model.alldata.AllPurch;
import com.stk.stk_sale.model.alldata.AllSale;
import com.stk.stk_sale.model.array.StkPurchArray;
import com.stk.stk_sale.model.array.StkSaleArray;
import com.stk.stk_sale.model.domain.Purch;
import com.stk.stk_sale.model.domain.Sale;
import com.stk.stk_sale.model.vo.SalePurchVo;
import com.stk.stk_sale.service.impl.PurchServiceImpl;
import com.stk.stk_sale.service.impl.SaleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
@Slf4j
class StkSaleApplicationTests {

}
