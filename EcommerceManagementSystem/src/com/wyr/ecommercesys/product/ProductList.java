package com.wyr.ecommercesys.product;

import com.wyr.ecommercesys.category.Category;
import com.wyr.ecommercesys.product.exception.ProductIdExisedException;
import com.wyr.ecommercesys.product.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> productList;
    ProductList(List<Product> productList) {
        this.productList = productList;
    }
    public ProductList() {
        this.productList = new ArrayList<>();
    }
    public ProductList(Product product) {
        this();
        this.productList.add(product);
    }
    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    // 通过id查找目标id对应列表中那一项。SerialNumber外部无需访问，使用private修饰
    // 返回-1即代表不存在
    // 设计这个函数是发现有很多功能都需要查找，比如说根据Id精准查找，判断是否存在等等，所以可以单独抽离出来
    private int getProductSerialNumberById(String productId){
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getProductId().equals(productId)){
                return i;
            }
        }
        return  -1;
    }
    //根据productId查找是否存在
    public boolean isProductExist(String productId){
        return getProductSerialNumberById(productId)!=-1;
    }

    public void addProduct(Product product){
        if(isProductExist(product.getProductId())){
            throw new ProductIdExisedException("wyr-添加商品错误：商品ID"+product.getProductId()+ "已存在！");
        }
        // product其他的合法检查（例如价格是否为负数，商品数量是否合法等）已经在product类中检查，这里无需检查
        productList.add(product);
    }

    public Product getProductById(String productId) throws ProductNotFoundException {
        int serialNum = getProductSerialNumberById(productId);
        if(serialNum==-1){
            throw new ProductNotFoundException("无法找到编号为" + productId + "的商品");
        }
        return productList.get(serialNum);
    }

    public ProductList query(String fuzzyWord){
        ProductList queryResult = new ProductList();
        for(Product product:productList){
            if((product.getProductName() + " "
                    + product.getCategoryList().getSimpleDescription())
                    .toLowerCase().contains(fuzzyWord.toLowerCase())){ //模糊匹配,规则是商品名、标签名中只要包含了目标词汇就加入
                queryResult.addProduct(product);
            }
        }
        return queryResult;
    }

    public ProductList query(Category category){
        //检索包含特定标签的
        ProductList queryResult = new ProductList();
        for(Product product:productList){
            if(product.getCategoryList().contains(category)){
                queryResult.addProduct(product);
            }
        }
        return queryResult;
    }
}
