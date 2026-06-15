package com.wyr.ecommercesys.category;

import java.util.ArrayList;
import java.util.List;

// 一个用户管理类别列表的类，这样子的好处是可以将类实现打组
public class CategoryList {
    protected List<Category> categoryList;

    public CategoryList(){
        categoryList = new ArrayList<Category>();
    }

    public CategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public Category addCategory(Category category){
        categoryList.add(category);
        return category;
    }

    public boolean contains(Category category){
        return contains(category.getCategoryName());
    }

    public boolean contains(String name){
        for(Category category : categoryList){
            if(category.getCategoryName().equals(name)){
                return true;
            }
        }
        return false;
    }

    //用于快速打印所有所属的类别
    public String getSimpleDescription(){
        if(categoryList.isEmpty()){
            return "暂无类别";
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<categoryList.size();i++){
            sb.append(categoryList.get(i).getCategoryName());
            if(i!=categoryList.size()-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void removeCategory(int index){
        categoryList.remove(index);
    }
}
