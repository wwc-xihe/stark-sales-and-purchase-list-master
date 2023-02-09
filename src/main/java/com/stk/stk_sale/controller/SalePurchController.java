package com.stk.stk_sale.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stk.stk_sale.mapper.PurchMapper;
import com.stk.stk_sale.mapper.SaleMapper;
import com.stk.stk_sale.model.domain.Purch;
import com.stk.stk_sale.model.domain.Sale;
import com.stk.stk_sale.model.vo.SalePurchVo;
import com.stk.stk_sale.service.SaleService;
import com.stk.stk_sale.service.impl.PurchServiceImpl;
import com.stk.stk_sale.service.impl.SaleServiceImpl;
import com.stk.stk_sale.utils.RetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class SalePurchController {
    @Resource
    private PurchMapper purchMapper;
    @Resource
    private PurchServiceImpl purchService;
    @Resource
    private SaleMapper saleMapper;

    /**
     * 销售订单和采购数据报表
     * @return
     */
    @RequestMapping("/stk/getData")
    public RetInfo getData(){
        List<SalePurchVo> purches = purchMapper.getSalePurch();
        return RetInfo.success(purches);
    }

    /**
     * 根据订单号或者代码查询
     * @param saleno
     * @param goodscode
     * @return
     */
    @RequestMapping("/stk/saleData")
    public RetInfo getSaleData(String saleno,String goodscode){
        IPage<SalePurchVo> iPage = purchMapper.selectSalePurch(new Page(1, 10), saleno, goodscode);
        return RetInfo.success(iPage);
    }

    /**
     * 更新单据锁定状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/stk/updateStatus")
    public RetInfo updateStatus(String id,String status){
        Sale sale=new Sale();
        sale.setVersion(status);
        int sales = saleMapper.update(sale,new UpdateWrapper<Sale>().eq("id",id));
        return RetInfo.success(sales);
    }

    /**
     * 查询需要采购的数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/stk/errorStatus")
    public RetInfo errorStatus(Integer pageNo,Integer pageSize){
        IPage<Sale> selectPage = saleMapper.selectSale(new Page<>(pageNo,pageSize));
        return RetInfo.success(selectPage);
    }

    /**
     * 根据单号查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/stk/errorPurch")
    public RetInfo errorPurch(Integer pageNo,Integer pageSize,String saleNo){
        IPage<Sale> selectPage = saleMapper.selectSaleByNo(new Page<>(pageNo,pageSize),saleNo);
        return RetInfo.success(selectPage);
    }
}
