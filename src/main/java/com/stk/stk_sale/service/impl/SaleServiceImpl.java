package com.stk.stk_sale.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stk.stk_sale.config.HttpClint;
import com.stk.stk_sale.model.StkSaleData;
import com.stk.stk_sale.model.alldata.AllSale;
import com.stk.stk_sale.model.array.StkSaleArray;
import com.stk.stk_sale.model.domain.Sale;
import com.stk.stk_sale.service.SaleService;
import com.stk.stk_sale.mapper.SaleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* @author 32657
* @description 针对表【t_sale】的数据库操作Service实现
* @createDate 2022-06-17 16:53:25
*/
@Service
@Slf4j
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale>
    implements SaleService{

    @Value("${http.urlPath}")
    private String urlPath;
    /**
     * 所有的销售数据
     */
    public List<AllSale> getAllSale(){
        String  url=urlPath+"zhuoangetsaleOrderList";
        HttpClint httpClint=new HttpClint();
        MultiValueMap param=new LinkedMultiValueMap();
        param.add("im_token","00e04c490b2210001");
        JSONObject jsonObject= JSON.parseObject(httpClint.HttpConfig(url,param));
        List<AllSale> saleList= JSONArray.parseArray(jsonObject.getString("array"),AllSale.class);
        Collections.sort(saleList, new Comparator<AllSale>() {
            @Override
            public int compare(AllSale o1, AllSale o2) {
                return Integer.parseInt(o2.getId())-Integer.parseInt(o1.getId());
            }
        });
        return saleList.subList(0,300);
    }
    /**
     * 插入销售接口的数据
     * @return
     */
    public boolean save(){
        List<AllSale> list=getAllSale();
        for (int i=0;i<list.size();i++){
            String url=urlPath+"zhuoangetBillBySaleOrder";
            MultiValueMap param=new LinkedMultiValueMap();
            param.add("im_token","2cf05dd6cf7e10801");
            param.add("saleOrderNumber",list.get(i).getSaleOrderNumber());
            HttpClint httpClint=new HttpClint();
            JSONObject jsonObject=JSONObject.parseObject(httpClint.HttpConfig(url,param));
            StkSaleData saleData=JSONObject.toJavaObject(jsonObject,StkSaleData.class);
            List<StkSaleArray> saleArrays= JSONArray.parseArray(jsonObject.getString("array"),StkSaleArray.class);
            Sale sale=new Sale();
            for (int j=0;j<saleArrays.size();j++){
                sale.setSaleno(list.get(i).getSaleOrderNumber());
                sale.setId(saleArrays.get(j).getId());
                sale.setSaleman(jsonObject.getString("salesman"));
                sale.setOffdate(saleArrays.get(j).getOfferDate());
                sale.setQuantity(saleArrays.get(j).getQuantity());
                sale.setGoodsname(saleArrays.get(j).getGoodsName());
                sale.setGoodscode(saleArrays.get(j).getGoodsCode());
                sale.setSalestatus(saleData.getIsOutstore());
                sale.setField16(saleArrays.get(j).getField16());
                sale.setField20(saleArrays.get(j).getField20());
                sale.setRemark(saleArrays.get(j).getRemark());
                this.saveOrUpdate(sale);}
        }
        log.info("销售数据抓取完成");
        return true;
    }

}




