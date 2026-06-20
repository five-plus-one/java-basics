package com.wyr.ecommercesys.core;

import com.wyr.ecommercesys.console.ConsoleUI;
import com.wyr.ecommercesys.input.EditProductInput;
import com.wyr.ecommercesys.input.InputTools;
import com.wyr.ecommercesys.order.Order;
import com.wyr.ecommercesys.order.OrderItem;
import com.wyr.ecommercesys.order.OrderItemList;
import com.wyr.ecommercesys.order.ShoppingCart;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.ProductList;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;
import com.wyr.ecommercesys.product.exception.ProductNotFoundException;
import com.wyr.ecommercesys.product.exception.ProductPriceIllegalException;



public class Core {
    private Core(){}
    public static void main(String[] args) {
        while(true){
            Pages.switchPage(0);
            int choice = InputTools.getIntWithGuide("功能编号",0,3);
            if(choice == 0){
                if(ExitPage()){
                    break;
                }
            }else if(choice == 1){
                ProductManage();
            }else if(choice == 2){
                OrderManage();
            }
        }
    }



    private static boolean ExitPage() {
        Pages.switchPage(4);
        if(Pages.showConfirm("退出","返回")){
            Pages.switchPage(4);
            return true;
        }else{
            return false;
        }
    }
    private static void OrderManage() {
        while(true){
            Pages.switchPage(2);
            int choice = InputTools.getIntWithGuide("功能编号",0,3);
            if(choice == 0){
                break;
            }
            switch (choice){
                case 1:
                    OrderCreate();
                    break;
                case 2:
                    OrderQuery();
                    break;
                case 3:
                    OrderShowAll();
                    break;
            }
        }
    }

    private static void OrderShowAll() {
        Pages.setCurrentPageStatus(8);
        Pages.renderCurrentPage();

        ConsoleUI.green("按下回车返回上一级\n");
        InputTools.waitForEnter();
    }

    private static void OrderQuery() {
        // [修复] 必须使用 Status 6 彻底隔离购物车界面
        Pages.setCurrentPageStatus(6);
        Pages.renderCurrentPage();

        String queryId = InputTools.getStrWithGuide("需要查询的订单号", true);
        Order targetOrder = null;
        for (Order order : Global.getCurrentOrderList().getOrderList()) {
            if (order.getOrderId().equals(queryId)) {
                targetOrder = order;
                break;
            }
        }

        Global.setCurrentGeneratedOrder(targetOrder);
        Pages.setCurrentPageStatus(7);
        Pages.renderCurrentPage();

        ConsoleUI.green("按下回车返回上一级\n");
        InputTools.waitForEnter();
    }


    private static void OrderCreate() {
        Global.setCurrentShoppingCart(new ShoppingCart());

        while (true) {
            Pages.setCurrentPageStatus(1);
            Pages.renderCurrentPage();

            ShoppingCart cart = Global.getCurrentShoppingCart();
            int choice = InputTools.getIntWithGuide("操作编号", 0, 3);

            if (choice == 0) {
                ConsoleUI.yellow("[系统提示] 已放弃下单，购物车已清空。\n");
                ConsoleUI.green("按下回车以继续\n");
                InputTools.waitForEnter();
                break;
            }
            else if (choice == 1) {
                Pages.setCurrentPageStatus(2);
                Pages.renderCurrentPage();

                String targetId = InputTools.getStrWithGuide("需要购买的商品编号");
                try {
                    Product p = Global.getCurrentProductList().getProductById(targetId);

                    int existingQty = 0;
                    for (OrderItem item : cart.getCartItems()) {
                        if (item.getProductSnapshot().getProductId().equals(targetId)) {
                            existingQty = item.getBuyQuantity();
                            break;
                        }
                    }
                    int availableStock = p.getQuantity() - existingQty;

                    if (availableStock <= 0) {
                        ConsoleUI.yellow("[系统拦截] 该商品已达最大物理库存限额，无法继续添加。\n");
                        ConsoleUI.green("按下回车以继续\n");
                        InputTools.waitForEnter();
                        continue;
                    }

                    Global.setCurrentOrderOperateProduct(p);
                    Pages.setCurrentPageStatus(3);
                    Pages.renderCurrentPage();

                    int addNum = InputTools.getIntWithGuide("添加数量(件) (输入0取消)", 0, availableStock);

                    if (addNum == 0) {
                        Pages.setCurrentPageStatus(2);
                        Pages.renderCurrentPage();
                        ConsoleUI.yellow("[系统提示] 已取消添加该商品。\n");
                    } else {
                        cart.addItemOrMerge(p, addNum);
                        Pages.setCurrentPageStatus(2);
                        Pages.renderCurrentPage();
                        ConsoleUI.green("[操作成功] 商品已加入购物车。\n");
                    }

                } catch (ProductNotFoundException | ProductQuantityIllegalException e) {
                    ConsoleUI.red("[操作失败] " + e.getMessage() + "\n");
                }
                ConsoleUI.green("按下回车以继续\n");
                InputTools.waitForEnter();
            }
            else if (choice == 2) {
                if (cart.isEmpty()) {
                    ConsoleUI.red("[操作失败] 购物车为空，无数据可修改。\n");
                    ConsoleUI.green("按下回车以继续\n");
                    InputTools.waitForEnter();
                    continue;
                }

                Pages.setCurrentPageStatus(2);
                Pages.renderCurrentPage();

                String targetId = InputTools.getStrWithGuide("需要修改数量的商品编号");
                try {
                    boolean inCart = false;
                    for (OrderItem item : cart.getCartItems()) {
                        if (item.getProductSnapshot().getProductId().equals(targetId)) {
                            inCart = true;
                            break;
                        }
                    }

                    if (!inCart) {
                        ConsoleUI.yellow("[系统拦截] 购物车中未找到编号为 " + targetId + " 的商品。\n");
                        ConsoleUI.green("按下回车以继续\n");
                        InputTools.waitForEnter();
                        continue;
                    }

                    Product p = Global.getCurrentProductList().getProductById(targetId);

                    Global.setCurrentOrderOperateProduct(p);
                    Pages.setCurrentPageStatus(4);
                    Pages.renderCurrentPage();

                    int newNum = InputTools.getIntWithGuide("新的购买数量 (输入0移出购物车)", 0, p.getQuantity());

                    cart.updateItemQuantity(targetId, newNum);

                    Pages.setCurrentPageStatus(2);
                    Pages.renderCurrentPage();

                    ConsoleUI.green("[操作成功] 数量修改完毕。\n");

                } catch (ProductNotFoundException | ProductQuantityIllegalException e) {
                    ConsoleUI.red("[操作失败] " + e.getMessage() + "\n");
                }
                ConsoleUI.green("按下回车以继续\n");
                InputTools.waitForEnter();
            }
            else if (choice == 3) {
                if (cart.isEmpty()) {
                    ConsoleUI.red("[操作拦截] 购物车为空，拒绝空单交易。\n");
                    ConsoleUI.green("按下回车以继续\n");
                    InputTools.waitForEnter();
                    continue;
                }

                Pages.setCurrentPageStatus(2);
                Pages.renderCurrentPage();

                if (Pages.showConfirm("支付并生成订单", "返回购物车修改")) {
                    try {
                        OrderItemList immutableList = cart.convertToOrderItemList();
                        Order newOrder = Global.getCurrentOrderList().createOrder(
                                immutableList,
                                Global.getCurrentProductList()
                        );

                        Global.setCurrentGeneratedOrder(newOrder);
                        Pages.setCurrentPageStatus(5);
                        Pages.renderCurrentPage();

                        ConsoleUI.green("按下回车返回主菜单\n");
                        InputTools.waitForEnter();
                        break;

                    } catch (ProductQuantityIllegalException | ProductNotFoundException e) {
                        ConsoleUI.red("\n[交易拦截] " + e.getMessage() + "\n");
                        ConsoleUI.yellow("请重新调整购物车内的库存依赖项。\n");
                        ConsoleUI.green("按下回车以继续\n");
                        InputTools.waitForEnter();
                    }
                }
            }
        }
    }

    private static void ProductManage() {
        while (true){
            Pages.switchPage(1);
            int choice = InputTools.getIntWithGuide("功能编号",0,5);
            if(choice == 0){break;}
            switch (choice){
                case 1:
                    ProductAdd();
                    break;
                case 2:
                    ProductQuery();
                    break;
                case 3:
                    ProductUpdate();
                    break;
                case 4:
                    ProductDelete();
                    break; //这里原来漏了个break，导致了穿透
                case 5:
                    ProductShowAll();
                    break;
            }
        }

    }

    private static void ProductDelete() {
        Pages.switchPage(9);
        Pages.setCurrentPageStatus(0);
        Pages.renderCurrentPage();
        String deleteProductId = InputTools.getStrWithGuide("需要删除的商品编号");
        try{
            Product product = Global.getCurrentProductList().getProductById(deleteProductId);
            Pages.setCurrentPageStatus(1);
            Pages.renderCurrentPage();
            if(Pages.showConfirm("删除","取消删除")){
                Global.getCurrentProductList().deleteProduct(product);
                ConsoleUI.green("删除成功，按下回车键以继续。");
                InputTools.waitForEnter();
            }else{
                ConsoleUI.green("已取消删除，按下回车键以继续。");
                InputTools.waitForEnter();
            }
        } catch (ProductNotFoundException e) {
            ConsoleUI.yellow("未找到该编号的商品：" + e.getMessage() + "。\n");
            ConsoleUI.green("按下回车键以继续。");
            InputTools.waitForEnter();
        }
    }

    private static void ProductUpdate() {
        Pages.switchPage(8);
        Pages.setCurrentPageStatus(6);
        Pages.renderCurrentPage();
        String updateProductId = InputTools.getStrWithGuide("需要修改的商品编号");
        try{
            Product product = Global.getCurrentProductList().getProductById(updateProductId);
            Global.setCurrentEditProduct(new EditProduct(product,true));
            int showSaveMenu = 0;
//            Pages.setCurrentPageStatus(4);
//            Pages.renderCurrentPage();
            //上面这两行，原来写在循环外面，测试的时候会发现页面无法正常刷新，应该写到循环里面
            while(true){
                Pages.setCurrentPageStatus(4);
                Pages.renderCurrentPage();
                int choice = InputTools.getIntWithGuide("功能编号",0,4);
                if(choice == 0){
                    break;
                }else{
                    showSaveMenu = 1;
                }
                switch (choice){
                    case 1:
                        EditProductInput.inputProductName();
                        break;
                    case 2:
                        EditProductInput.inputProductCategory();
                        break;
                    case 3:
                        EditProductInput.inputProductPrice();
                        break;
                    case 4:
                        EditProductInput.inputProductQuantity();
                        break;
                }
            }
            if(showSaveMenu > 0){
                Pages.setCurrentPageStatus(5);
                Pages.renderCurrentPage();
                if(Pages.showConfirm("更新商品信息","取消更新")){
                    product = Global.getCurrentEditProduct().convertToProduct();
                    // 这样无法完成更新，为什么？
                    // 仅仅改变了 Core 类里 product 这个局部变量的指向，
                    // 而 ProductList 内部那个真正的 List<Product> 集合里，依然存放着原来那个旧对象的引用，
                    // 集合本身并没有被修改。
                    // 所以需要单独增加一个更新的方法
                    Global.getCurrentProductList().updateProduct(product);
                    ConsoleUI.green("商品信息更新成功！\n");
                }else{
                    ConsoleUI.green("已取消更新商品信息。\n");
                }
                ConsoleUI.green("按下回车键以继续");
                InputTools.waitForEnter();
            }
        } catch (ProductNotFoundException e) {
            ConsoleUI.yellow("未找到该编号的商品：" + e.getMessage() + "。\n");
            ConsoleUI.green("按下回车键以继续。");
            InputTools.waitForEnter();
        } catch (ProductPriceIllegalException e) {
            ConsoleUI.yellow("商品价格不合法：" + e.getMessage() + "。\n");
            ConsoleUI.green("按下回车键以继续。");
            InputTools.waitForEnter();
        } catch (ProductQuantityIllegalException e) {
            ConsoleUI.yellow("商品库存不合法：" + e.getMessage() + "。\n");
            ConsoleUI.green("按下回车键以继续。");
            InputTools.waitForEnter();
        }
    }

    private static void ProductShowAll() {
        Pages.switchPage(6);
        ConsoleUI.printProductList(Global.getCurrentProductList());
        ConsoleUI.printDivider();
        ConsoleUI.green("按下回车键以退出");
        InputTools.waitForEnter();
    }

    private static void ProductQuery() {
        Pages.switchPage(7);
        while(true){
            Pages.setCurrentPageStatus(1);
            Pages.renderCurrentPage();
            int choice = InputTools.getIntWithGuide("功能编号",0,3);
            if(choice == 0){
                break;
            }else if(choice == 1){
                Pages.setCurrentPageStatus(2);
                Pages.renderCurrentPage();
                String queryId = InputTools.getStrWithGuide("需要查询的商品编号",true);
                Pages.renderCurrentPage();
                try{
                    Product product = Global.getCurrentProductList().getProductById(queryId);
                    System.out.println("查询结果如下：");
                    ConsoleUI.printProductList(new ProductList(product));
                } catch (ProductNotFoundException e) {
                    ConsoleUI.yellow("未找到商品：" + e.getMessage() + "\n");
                }
                ConsoleUI.green("按下回车键以继续");
                InputTools.waitForEnter();
            }else if(choice == 2){
                Pages.setCurrentPageStatus(3);
                Pages.renderCurrentPage();
                String fuzzyQueryName = InputTools.getStrWithGuide("模糊查询的名称",true);
                ProductList FuzzyQueryResult = Global.getCurrentProductList().query(fuzzyQueryName);
                ConsoleUI.printProductList(FuzzyQueryResult);
                ConsoleUI.green("按下回车键以继续");
                InputTools.waitForEnter();
            }else if(choice == 3){
                Pages.setCurrentPageStatus(4);
                Pages.renderCurrentPage();
                String queryCategoryName = InputTools.getStrWithGuide("分类",true);

                //调试代码
//                System.out.println("---");
//                Global.getCategoryPool().test_printCategoryList();
//                System.out.println("---");

                // 这里一开始写的时候出了问题，if,else里面的内容我写错了，后来通过添加调试代码，找出了问题
                if(Global.getCategoryPool().hasCategory(queryCategoryName)){
                    ProductList queryResult = Global.getCurrentProductList().query(
                            Global.getCategoryPool().getCategoryByName(queryCategoryName)
                    );
                    ConsoleUI.printProductList(queryResult);
                }else{
                    ConsoleUI.yellow("不存在分类名为" + queryCategoryName + "的分类!\n\n");
                }
                ConsoleUI.green("按下回车键以继续");
                InputTools.waitForEnter();
            }
        }
    }

    private static void ProductAdd() {
        Pages.switchPage(5);
        Global.setCurrentEditProduct(new EditProduct());
        EditProductInput.inputProductId();
        EditProductInput.inputProductName();
        EditProductInput.inputProductPrice();
        EditProductInput.inputProductQuantity();
        EditProductInput.inputProductCategory();
        if(Pages.showConfirm("添加","取消添加")){
            try {
                Global.getCurrentProductList().addProduct(Global.getCurrentEditProduct().convertToProduct());
                ConsoleUI.green("添加成功。按下回车以继续");
                InputTools.waitForEnter();
            } catch (ProductPriceIllegalException | ProductQuantityIllegalException e) {
                ConsoleUI.red("添加失败：" + e.getMessage() + " \n按下回车以继续");
                InputTools.waitForEnter();
            }
        }else{
            ConsoleUI.yellow("已取消添加，按下回车键回到首页");
            InputTools.waitForEnter();
        }
    }
}
