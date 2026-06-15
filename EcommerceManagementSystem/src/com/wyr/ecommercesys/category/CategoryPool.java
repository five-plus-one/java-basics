package com.wyr.ecommercesys.category;

public class CategoryPool extends CategoryList{
    public CategoryPool(){
        super();
    }
    public Category getCategoryByName(String categoryName){
        for (Category category : categoryList){
            if(category.getCategoryName().equals(categoryName)){
                return category;
            }
        }
        return addCategory(new Category(categoryName));
    }
}
