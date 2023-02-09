package com.stk.stk_sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stk.stk_sale.model.domain.Purch;
import com.stk.stk_sale.model.vo.SalePurchVo;

import java.util.List;

/**
* @author 32657
* @description 针对表【t_purch】的数据库操作Mapper
* @createDate 2022-06-20 08:48:11
* @Entity generator.domain.Purch
*/
public interface PurchMapper extends BaseMapper<Purch> {
    IPage<SalePurchVo> selectSalePurch(Page page,String saleno,String goodscode);

    List<SalePurchVo> getSalePurch();
}




