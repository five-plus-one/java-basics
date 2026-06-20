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

    public boolean hasCategory(String categoryName){
       return contains(categoryName);
    }

    //测试代码，帮助排查现在标签池中有什么
//    public void test_printCategoryList(){
//        for (Category category : categoryList){
//            System.out.println(category.getCategoryName());
//        }
//    }
}
