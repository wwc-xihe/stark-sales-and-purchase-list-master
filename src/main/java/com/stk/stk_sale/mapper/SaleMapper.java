package com.stk.stk_sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stk.stk_sale.model.domain.Sale;

/**
* @author 32657
* @description 针对表【t_sale】的数据库操作Mapper
* @createDate 2022-06-24 16:29:17
* @Entity generator.domain.Sale
*/
public interface SaleMapper extends BaseMapper<Sale> {
    IPage<Sale> selectSale(Page page);
    IPage<Sale> selectSaleByNo(Page page,String saleNo);
}




