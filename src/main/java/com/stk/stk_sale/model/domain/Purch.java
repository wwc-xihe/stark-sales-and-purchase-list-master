package com.stk.stk_sale.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_purch
 */
@TableName(value ="t_purch")
@Data
public class Purch implements Serializable {
    /**
     * 序号
     */
    @TableId
    private Integer id;

    /**
     * 采购单号
     */
    private String purchno;

    /**
     * 关联单号
     */
    private String contractid;

    /**
     * 品名
     */
    private String goodsname;

    /**
     * 数量
     */
    private String quantity;

    /**
     * 入库状态 0 未入库 3 已入库
     */
    @TableField(value = "store_status")
    private String storeStatus;

    /**
     * 交货日期
     */
    private String offdate;

    /**
     * 采购员
     */
    private String buyer;

    /**
     * 代码
     */
    private String goodscode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Purch other = (Purch) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPurchno() == null ? other.getPurchno() == null : this.getPurchno().equals(other.getPurchno()))
            && (this.getContractid() == null ? other.getContractid() == null : this.getContractid().equals(other.getContractid()))
            && (this.getGoodsname() == null ? other.getGoodsname() == null : this.getGoodsname().equals(other.getGoodsname()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getStoreStatus() == null ? other.getStoreStatus() == null : this.getStoreStatus().equals(other.getStoreStatus()))
            && (this.getOffdate() == null ? other.getOffdate() == null : this.getOffdate().equals(other.getOffdate()))
            && (this.getBuyer() == null ? other.getBuyer() == null : this.getBuyer().equals(other.getBuyer()))
            && (this.getGoodscode() == null ? other.getGoodscode() == null : this.getGoodscode().equals(other.getGoodscode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPurchno() == null) ? 0 : getPurchno().hashCode());
        result = prime * result + ((getContractid() == null) ? 0 : getContractid().hashCode());
        result = prime * result + ((getGoodsname() == null) ? 0 : getGoodsname().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getStoreStatus() == null) ? 0 : getStoreStatus().hashCode());
        result = prime * result + ((getOffdate() == null) ? 0 : getOffdate().hashCode());
        result = prime * result + ((getBuyer() == null) ? 0 : getBuyer().hashCode());
        result = prime * result + ((getGoodscode() == null) ? 0 : getGoodscode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", purchno=").append(purchno);
        sb.append(", contractid=").append(contractid);
        sb.append(", goodsname=").append(goodsname);
        sb.append(", quantity=").append(quantity);
        sb.append(", storeStatus=").append(storeStatus);
        sb.append(", offdate=").append(offdate);
        sb.append(", buyer=").append(buyer);
        sb.append(", goodscode=").append(goodscode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}