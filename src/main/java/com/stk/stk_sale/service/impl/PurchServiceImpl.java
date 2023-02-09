package com.stk.stk_sale.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stk.stk_sale.config.HttpClint;
import com.stk.stk_sale.mapper.PurchMapper;
import com.stk.stk_sale.model.StkPurchData;
import com.stk.stk_sale.model.alldata.AllPurch;
import com.stk.stk_sale.model.alldata.AllSale;
import com.stk.stk_sale.model.array.StkPurchArray;
import com.stk.stk_sale.model.domain.Purch;
import com.stk.stk_sale.service.PurchService;
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
* @description 针对表【t_purch】的数据库操作Service实现
* @createDate 2022-06-17 16:51:45
*/
@Service
@Slf4j
public class PurchServiceImpl extends ServiceImpl<PurchMapper, Purch>
    implements PurchService {
    @Value("${http.urlPath}")
    private String urlPath;

    /**
     * 所有的采购数据
     */
    public List<AllPurch> getAllPurch(){
        String  url=urlPath+"zhuoangetpurchaseOrderList";
        HttpClint httpClint=new HttpClint();
        MultiValueMap param=new LinkedMultiValueMap();
        param.add("im_token","00e04c490b2210001");
        JSONObject jsonObject= JSON.parseObject(httpClint.HttpConfig(url,param));
        List<AllPurch> purchList= JSONArray.parseArray(jsonObject.getString("array"),AllPurch.class);
        Collections.sort(purchList, new Comparator<AllPurch>() {
            @Override
            public int compare(AllPurch o1, AllPurch o2) {
                return Integer.parseInt(o2.getId())-Integer.parseInt(o1.getId());
            }
        });
        return purchList.subList(0,300);
    }

    /**
     * 插入数据
     * @return
     */
    public boolean save(){
        List<AllPurch> list = getAllPurch();
        for (int i=0;i<list.size();i++){
            String url=urlPath+"zhuoanfindByPurchaseOrderId";
            MultiValueMap param=new LinkedMultiValueMap();
            param.add("im_token","2cf05dd6cf7e10801");
            param.add("purchaseOrderNumber",list.get(i).getPurchaseOrderNumber());
            HttpClint httpClint=new HttpClint();
            JSONObject jsonObject=JSONObject.parseObject(httpClint.HttpConfig(url,param));
            StkPurchData purchData=JSONObject.toJavaObject(jsonObject,StkPurchData.class);
            List<StkPurchArray> purchArrays= JSONArray.parseArray(jsonObject.getString("array"),StkPurchArray.class);
            Purch purch=new Purch();
            for (int j=0;j<purchArrays.size();j++){
                purch.setPurchno(list.get(i).getPurchaseOrderNumber());
                purch.setId(purchArrays.get(j).getId());
                purch.setBuyer(jsonObject.getString("buyer"));
                purch.setOffdate(purchArrays.get(j).getOfferDate());
                purch.setQuantity(purchArrays.get(j).getQuantity());
                purch.setGoodsname(purchArrays.get(j).getGoodsName());
                purch.setGoodscode(purchArrays.get(j).getGoodsCode());
                purch.setContractid(jsonObject.getString("contractId"));
                purch.setStoreStatus(jsonObject.getString("inStoreStatus"));
                this.saveOrUpdate(purch);
            }
        }
        log.info("采购数据抓取完成");
        return true;
    }

}




