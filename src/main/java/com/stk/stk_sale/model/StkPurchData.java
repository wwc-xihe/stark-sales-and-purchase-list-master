package com.stk.stk_sale.model;

import com.stk.stk_sale.model.array.StkPurchArray;
import lombok.Data;

import java.util.List;

/**
 * 单张采购单的数据
 */
@Data
public class StkPurchData {
    private String contractId;//采购关联销售订单
    private String inStoreStatus;//采购入库情况 3 入库 0 未通知 1 已通知  2 部分通知
    private List<StkPurchArray> array;
    private String buyer;
}
