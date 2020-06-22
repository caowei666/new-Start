package com.vince.ui;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.vince.bean.Clothes;
import com.vince.bean.Order;
import com.vince.bean.OrderItem;
import com.vince.service.ClothesService;
import com.vince.service.OrderService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.service.impl.OrderServiceImpl;
import com.vince.utils.BusinessException;
import com.vince.utils.ClothesIO;
import com.vince.utils.DateUtils;
import com.vince.utils.TTable;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass {
    //private OrderService orderService = new OrderServiceImpl();
    //private ClothesService clothesService = new ClothesServiceImpl();
    private OrderService orderService;
    private ClothesService clothesService;

    public HomeClass(){
        orderService = (OrderService) beanFactory.getBean("orderService");
        clothesService = (ClothesService) beanFactory.getBean("clothesService");
    }

    public void show(){
        showProducts();
        println("welcome:"+curruser.getUsername());
        menu();
    }

    private void menu() {
        boolean flag = true;
        while (flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":   //查询全部订单
                    findOrderList();
                    flag = false;
                    break;
                case "2":   //查询订单
                    findOrderByID();
                    flag = false;
                    break;
                case "3":   //购买
                    try {
                        buyProducts();
                        flag = false;
                    }catch (BusinessException e){
                        println(e.getMessage());
                    }
                    break;
                case "4":
                    show();  //显示商品
                    break;
                case "0":   //退出
                    flag = false;
                    println(getString("info.exit"));
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    /**
     * 购买商品
     */
    private void buyProducts() throws BusinessException {
        //生成订单
        boolean flag = true;
        int count = 1;
        float sum = 0.0f;  //订单总金额
        Order order = new Order();   //生成的订单
        while (flag){
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(id);
            int num = Integer.parseInt(shoppingNum);
            if(num>clothes.getNum()){
                throw new BusinessException("product.num.error");
            }
            //一条订单明细
            clothes.setNum(clothes.getNum() - num);  //减去库存
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);
            println(getString("product.buy.continue"));
            String isbuy = input.nextLine();
            switch (isbuy){
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setOrderId(curruser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProduct(order);
        clothesService.update();
        show();
    }

    private void findOrderByID() {
        println(getString("product.order.input.oid"));
        String oid = input.nextLine();
        Order order = orderService.findById(Integer.parseInt(oid));
        if(order != null){
            showOrder(order);
        }else {
            println(getString("product.order.error"));
        }
        menu();
    }

    private void findOrderList() {
        List<Order> list = orderService.list();
        for (Order o:list){
            showOrder(o);
        }
        menu();
    }

    private void showOrder(Order o) {
        print(getString("product.order.oid") + o.getOrderId());
        print("\t"+getString("product.order.createDate") + o.getCreateDate());
        println("\t"+getString("product.order.sum")+o.getSum());
        TTable<OrderItem> tTable = new TTable<>();
        tTable.addColumn(" itemId","itemId",10);
        tTable.addColumn(" shoppingNum","shoppingNum",10);
        tTable.addColumn(" sum","sum",10);
        tTable.addColumn(" clothes","clothes",100);
//        tTable.addColumn(" brand","brand",10);
//        tTable.addColumn(" style","style",10);
//        tTable.addColumn(" color","color",10);
//        tTable.addColumn(" size","size",10);
//        tTable.addColumn(" price","price",10);
//        tTable.addColumn(" description","description",20);
        tTable.printHeader();
        tTable.printBeans(o.getOrderItemList());
        println("");
    }

    private void showProducts(){
        ClothesService clothesService = new ClothesServiceImpl();
        List<Clothes> list = clothesService.list();
        TTable<Clothes> tTable = new TTable<Clothes>();
        tTable.addColumn(" id","id",10);
        tTable.addColumn(" brand","brand",10);
        tTable.addColumn(" style","style",10);
        tTable.addColumn(" color","color",10);
        tTable.addColumn(" size","size",10);
        tTable.addColumn(" num","num",10);
        tTable.addColumn(" price","price",15);
        tTable.addColumn(" description","description",80);
        tTable.printHeader();
        tTable.printBeans(list);
        println("");
    }
}
