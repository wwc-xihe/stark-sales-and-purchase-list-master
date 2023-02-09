package com.stk.stk_sale.service;

import com.stk.stk_sale.model.domain.Sale;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 32657
* @description 针对表【t_sale】的数据库操作Service
* @createDate 2022-06-17 16:53:25
*/
public interface SaleService extends IService<Sale> {
    boolean save();
}
