package com.wyr.ecommercesys.io;

import com.wyr.ecommercesys.category.CategoryList;
import com.wyr.ecommercesys.core.Global;
import com.wyr.ecommercesys.order.Order;
import com.wyr.ecommercesys.order.OrderItem;
import com.wyr.ecommercesys.order.OrderItemList;
import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.ProductSnapshot;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTools {
    private FileTools(){}

    private static final String GOODS_FILE = "goods_2535010212.txt";
    private static final String ORDER_FILE = "order_2535010212.txt";

    // 编码
    private static String encode(String data) {
        if (data == null) data = "";
        return data.length() + ":" + data;
    }

    // 解码：极其严格的校验，任何不匹配直接抛出异常
    private static List<String> decode(String line) throws DataCorruptedException {
        List<String> result = new ArrayList<>();
        int currentIndex = 0;
        while (currentIndex < line.length()) {
            int colonIndex = line.indexOf(":", currentIndex);
            if (colonIndex == -1) {
                throw new DataCorruptedException("wyr-解析异常：找不到长度定界符 ':'。脏数据：" + line);
            }
            try {
                int length = Integer.parseInt(line.substring(currentIndex, colonIndex));
                int start = colonIndex + 1;
                if (start + length > line.length()) {
                    throw new DataCorruptedException("wyr-解析异常：声明的长度超出了实际数据边界。");
                }
                result.add(line.substring(start, start + length));
                currentIndex = start + length;
            } catch (NumberFormatException e) {
                throw new DataCorruptedException("wyr-解析异常：长度标识符非合法整数。脏数据：" + line);
            }
        }
        return result;
    }

    // 保存所有商品：将异常抛给 Core
    public static void saveProducts() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(GOODS_FILE))) {
            for (Product p : Global.getCurrentProductList().getProductList()) {
                StringBuilder sb = new StringBuilder();
                sb.append(encode(p.getProductId()));
                sb.append(encode(p.getProductName()));
                sb.append(encode(p.getCategoryList().getSimpleDescription()));
                sb.append(encode(String.valueOf(p.getPrice())));
                sb.append(encode(String.valueOf(p.getQuantity())));
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }

    // 读取所有商品：将异常抛给 Core
    public static void loadProducts() throws IOException, DataCorruptedException {
        File file = new File(GOODS_FILE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> fields = decode(line);
                if (fields.size() < 5) throw new DataCorruptedException("wyr-解析异常：商品数据字段缺失。");

                String id = fields.get(0);
                String name = fields.get(1);
                String categoryStr = fields.get(2);
                double price = Double.parseDouble(fields.get(3));
                int quantity = Integer.parseInt(fields.get(4));

                CategoryList cl = new CategoryList();
                if (!categoryStr.equals("暂无类别") && !categoryStr.isEmpty()) {
                    String[] catNames = categoryStr.split(",");
                    for (String cName : catNames) {
                        cl.addCategory(Global.getCategoryPool().getCategoryByName(cName));
                    }
                }

                Product p = new Product(id, name, cl, price, quantity, true);
                Global.getCurrentProductList().addProduct(p);
            }
        }
    }

    // 保存所有订单：将异常抛给 Core
    public static void saveOrders() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDER_FILE))) {
            for (Order o : Global.getCurrentOrderList().getOrderList()) {
                StringBuilder sb = new StringBuilder();
                sb.append(encode(o.getOrderId()));
                sb.append(encode(String.valueOf(o.getFinalPrice())));

                List<OrderItem> items = o.getOrderItemList().getItemList();
                sb.append(encode(String.valueOf(items.size())));

                for (OrderItem item : items) {
                    ProductSnapshot snap = item.getProductSnapshot();
                    sb.append(encode(snap.getProductId()));
                    sb.append(encode(snap.getProductName()));
                    sb.append(encode(String.valueOf(snap.getPrice())));
                    sb.append(encode(String.valueOf(item.getBuyQuantity())));
                }
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }

    // 读取所有订单：将异常抛给 Core
    public static void loadOrders() throws IOException, DataCorruptedException {
        File file = new File(ORDER_FILE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> fields = decode(line);
                if (fields.size() < 3) throw new DataCorruptedException("wyr-解析异常：订单数据字段缺失。");

                String orderId = fields.get(0);
                double finalPrice = Double.parseDouble(fields.get(1));
                int itemCount = Integer.parseInt(fields.get(2));

                List<OrderItem> loadedItems = new ArrayList<>();
                int pointer = 3;

                for (int i = 0; i < itemCount; i++) {
                    if (pointer + 3 >= fields.size()) {
                        throw new DataCorruptedException("wyr-解析异常：订单明细数量与实际字段数不匹配。");
                    }
                    String pId = fields.get(pointer++);
                    String pName = fields.get(pointer++);
                    double pPrice = Double.parseDouble(fields.get(pointer++));
                    int buyQty = Integer.parseInt(fields.get(pointer++));

                    Product tmpProduct = new Product(pId, pName, new CategoryList(), pPrice, 999, true);
                    try {
                        OrderItem item = new OrderItem(tmpProduct, buyQty);
                        loadedItems.add(item);
                    } catch (Exception | ProductQuantityIllegalException e) {
                        throw new DataCorruptedException("wyr-解析异常：无法重建订单明细。");
                    }
                }

                OrderItemList itemList = new OrderItemList(loadedItems);
                Order restoredOrder = new Order(orderId, finalPrice, itemList);
                Global.getCurrentOrderList().addOrder(restoredOrder);
            }
        }
    }
}