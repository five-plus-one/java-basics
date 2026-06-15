package com.wyr.ecommercesys.category;

// 分类的基础类
public class Category {
    private static int categoryCounter = 0; //计数器，用于自动生成新的唯一ID
    private String categoryName;
    private String categoryId;  //id属性，这样修改类别名称的时候就不用所有地方做改动了
    protected Category(String categoryName){
        this.categoryName = categoryName;
        categoryCounter++;
        this.categoryId = "wyr-category-" + categoryCounter; //自动赋予ID,wyr是我的姓名首字母:D
        //实际上，这个categoryId并不会对用户暴露，作为唯一id，方便直接修改标签名称
    }
    protected Category(String categoryId, String categoryName){
        this.categoryId = categoryId;
        categoryCounter++;
        this.categoryName = categoryName;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    //重写toString方法，从而可以直接返回到名称
    @Override
    public String toString() {
        return categoryName;
    }
}
