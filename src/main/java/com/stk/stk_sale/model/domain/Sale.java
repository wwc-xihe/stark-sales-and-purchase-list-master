package com.stk.stk_sale.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_sale
 */
@TableName(value ="t_sale")
@Data
public class Sale implements Serializable {
    /**
     * 序号
     */
    @TableId
    private Integer id;

    /**
     * 销售单号
     */
    private String saleno;

    /**
     * 产品名
     */
    private String goodsname;

    /**
     * 数量
     */
    private String quantity;

    /**
     * 销售员
     */
    private String saleman;

    /**
     * 交货时间
     */
    private String offdate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标牌
     */
    private String field16;

    /**
     * 代码
     */
    private String goodscode;

    /**
     * 锁定状态 0 显示 1 不显示
     */
    private String salestatus;

    /**
     * 是否采购 1 采购 0 不采购
     */
    private String field20;

    /**
     * 单据锁定
     */
    private String version;

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
        Sale other = (Sale) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSaleno() == null ? other.getSaleno() == null : this.getSaleno().equals(other.getSaleno()))
            && (this.getGoodsname() == null ? other.getGoodsname() == null : this.getGoodsname().equals(other.getGoodsname()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getSaleman() == null ? other.getSaleman() == null : this.getSaleman().equals(other.getSaleman()))
            && (this.getOffdate() == null ? other.getOffdate() == null : this.getOffdate().equals(other.getOffdate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getField16() == null ? other.getField16() == null : this.getField16().equals(other.getField16()))
            && (this.getGoodscode() == null ? other.getGoodscode() == null : this.getGoodscode().equals(other.getGoodscode()))
            && (this.getSalestatus() == null ? other.getSalestatus() == null : this.getSalestatus().equals(other.getSalestatus()))
            && (this.getField20() == null ? other.getField20() == null : this.getField20().equals(other.getField20()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSaleno() == null) ? 0 : getSaleno().hashCode());
        result = prime * result + ((getGoodsname() == null) ? 0 : getGoodsname().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getSaleman() == null) ? 0 : getSaleman().hashCode());
        result = prime * result + ((getOffdate() == null) ? 0 : getOffdate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getField16() == null) ? 0 : getField16().hashCode());
        result = prime * result + ((getGoodscode() == null) ? 0 : getGoodscode().hashCode());
        result = prime * result + ((getSalestatus() == null) ? 0 : getSalestatus().hashCode());
        result = prime * result + ((getField20() == null) ? 0 : getField20().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleno=").append(saleno);
        sb.append(", goodsname=").append(goodsname);
        sb.append(", quantity=").append(quantity);
        sb.append(", saleman=").append(saleman);
        sb.append(", offdate=").append(offdate);
        sb.append(", remark=").append(remark);
        sb.append(", field16=").append(field16);
        sb.append(", goodscode=").append(goodscode);
        sb.append(", salestatus=").append(salestatus);
        sb.append(", field20=").append(field20);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}