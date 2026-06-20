package com.wyr.ecommercesys.order;
import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.ProductSnapshot;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;


// 订单方面整体设计：参考一下之前标签的设计，使用
// OrderItem,OrderItemList（多个OrderItem)，
// Order（创建需要传入一个OrderItemList），OrderList（包含多个Order）

//订单明细项，一个订单可以包含多个明细
public class OrderItem {
    private ProductSnapshot productSnapshot;
    private int buyQuantity;

    public OrderItem(Product realProduct,int buyQuantity) throws ProductQuantityIllegalException {
        if(buyQuantity<=0){
            throw new ProductQuantityIllegalException("wyr-订单项异常：购买数量必须大于0");
        }
        this.productSnapshot = new ProductSnapshot(realProduct);
        this.buyQuantity = buyQuantity;
    }

    // 为了方便购物车在不查底层商品库的情况下直接克隆数据，我们给 OrderItem 加一个重载的构造方法（仅限同包内使用）。
    protected OrderItem(ProductSnapshot snapshot, int buyQuantity) throws ProductQuantityIllegalException {
        if (buyQuantity <= 0) {
            throw new ProductQuantityIllegalException("wyr-订单项异常：购买数量必须大于0");
        }
        this.productSnapshot = snapshot;
        this.buyQuantity = buyQuantity;
    }

    // 订单项目一旦创建，不应该被修改，所以不提供setter

    public ProductSnapshot getProductSnapshot() {
        return productSnapshot;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public double getSubTotal(){
        return this.productSnapshot.getPrice()*this.buyQuantity;
    }



    @Override
    public String toString(){
        return String.format("商品编号:%s | 名称: %s | 分类:%s | 单价: %.2f元 | 数量: %d | 小计: %.2f元",
                productSnapshot.getProductId(),
                productSnapshot.getProductName(),
                productSnapshot.getCategoryDesc(),
                productSnapshot.getPrice(),
                buyQuantity,
                getSubTotal()
                );
    }
}
