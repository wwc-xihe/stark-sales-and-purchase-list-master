package com.stk.stk_sale.model;

import com.stk.stk_sale.model.array.StkSaleArray;
import lombok.Data;

import java.util.List;

@Data
public class StkSaleData {
    private List<StkSaleArray> array;
    private String saleman;
    private String isOutstore;
}
