package com.wyr.ecommercesys.product;

import com.wyr.ecommercesys.category.CategoryList;
import com.wyr.ecommercesys.product.exception.EditProductNotCompletedException;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;
import com.wyr.ecommercesys.product.exception.ProductPriceIllegalException;

import java.util.LinkedHashMap;
import java.util.Map;

//商品编辑类，增加了编辑状态的提示，用于商品录入或商品编辑
public class EditProduct extends Product{
    private boolean isSetProductId = false;
    private boolean isSetProductName = false;
    private boolean isSetProductPrice = false;
    private boolean isSetProductQuantity = false;
    private boolean isSetCategoryList = false;
    public EditProduct() {
        super("","",new CategoryList(),10,10,true); //临时数据
    }
    public EditProduct(Product product) throws ProductPriceIllegalException, ProductQuantityIllegalException {
        this();
        setProductId(product.getProductId());
        setProductName(product.getProductName());
        setCategoryList(product.getCategoryList());
        setPrice(product.getPrice());
        setQuantity(product.getQuantity());
    }
    public EditProduct(Product product,Boolean ignore){
        super(product.getProductId(),product.getProductName(),
                product.getCategoryList(), product.getPrice(),
                product.getQuantity(),ignore);
    }

    @Override
    public void setProductId(String productId) {
        super.setProductId(productId);
        isSetProductId = true;
    }

    @Override
    public void setProductName(String productName) {
        super.setProductName(productName);
        isSetProductName = true;
    }

    @Override
    public void setCategoryList(CategoryList categoryList) {
        super.setCategoryList(categoryList);
        isSetCategoryList = true;
    }

    @Override
    public void setPrice(double price) throws ProductPriceIllegalException {
        super.setPrice(price);
        isSetProductPrice = true;
    }

    @Override
    public void setQuantity(int quantity) throws ProductQuantityIllegalException {
        super.setQuantity(quantity);
        isSetProductQuantity = true;
    }
    public Map<String,String> getInfoShowMap(){
        Map<String,String> map = new LinkedHashMap<>();
        if(isSetProductId){
            map.put("商品编号",getProductId());
        }
        if(isSetProductName){
            map.put("商品名称",getProductName());
        }
        if(isSetCategoryList){
            map.put("商品分类", getCategoryList().getSimpleDescription());
        }
        if(isSetProductPrice){
            map.put("商品价格",String.format("%.2f",getPrice()));
        }
        if(isSetProductQuantity){
            map.put("库存数量",getQuantity()+"");
        }
        return map;
    }
    public boolean isSetCategoryList(){
        return isSetCategoryList;
    }
    public boolean isEmpty(){
        return (!isSetProductId&&!isSetProductName&&!isSetProductPrice&&!isSetProductQuantity&& !isSetCategoryList);
    }
    public boolean isComplete(){
        return isSetProductId && isSetProductName && isSetProductPrice && isSetProductQuantity && isSetCategoryList;
    }

    public Product convertToProduct() throws ProductPriceIllegalException, ProductQuantityIllegalException {
        if(isComplete()){
            return new Product(getProductId(),getProductName(),getCategoryList(),getPrice(),getQuantity());
        }else{
            throw new EditProductNotCompletedException("wyr-商品编辑未完成");
        }
    }
}
