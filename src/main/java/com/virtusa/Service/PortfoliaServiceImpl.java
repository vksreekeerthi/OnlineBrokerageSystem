package com.virtusa.Service;


import com.virtusa.DAO.OrderRepository;
import com.virtusa.Entity.Order;
import com.virtusa.Entity.mystock;
import jdk.internal.module.ModuleBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;



@Service
public class PortfoliaServiceImpl implements PortfolioService {

    @Autowired
    OrderRepository orderRepository;

    public List<mystock> stocksAvailable(int id) {
    System.out.println("inside");

        List<Order> orders = orderRepository.findAll().stream().filter(a -> a.getCustId() == id).collect(Collectors.toList());
    Set<Integer> uniqueorder = new HashSet<Integer>();
    Map<Integer, mystock> map = new HashMap<Integer, mystock>();
    List<mystock> mystocklist = new ArrayList<>();
        for(
    Order uniqueobj :orders)

    {
        uniqueorder.add(uniqueobj.getStockId());
    }

        for(
    Order orderobj :orders)

    {
        if (map.containsKey(orderobj.getStockId())) {
            mystock mystockobj = new mystock();
            mystockobj.setStockId(orderobj.getStockId());
            mystockobj.setStockLabel(orderobj.getStockLabel());
            mystockobj.setStockName(orderobj.getStockName());
            mystockobj.setStockQuantity(0);
            if (orderobj.getOrderType().equals("Buy")) {

                mystockobj.setStockQuantity(map.getOrDefault(orderobj.getStockId(), mystockobj).stockQuantity + orderobj.getOrderQuantity());
                map.put(orderobj.getStockId(), mystockobj);
                System.out.println(map);

            } else {
                mystockobj.setStockQuantity(map.getOrDefault(orderobj.getStockId(), mystockobj).stockQuantity - orderobj.getOrderQuantity());
                map.put(orderobj.getStockId(), mystockobj);
                System.out.println(map);
            }
        } else {
            mystock mystockobj = new mystock();
            mystockobj.setStockId(orderobj.getStockId());
            mystockobj.setStockLabel(orderobj.getStockLabel());
            mystockobj.setStockName(orderobj.getStockName());
            mystockobj.setStockQuantity(0);
            if (orderobj.getOrderType().equals("Buy")) {

                mystockobj.setStockQuantity(map.getOrDefault(orderobj.getStockId(), mystockobj).stockQuantity + orderobj.getOrderQuantity());
                map.put(orderobj.getStockId(), mystockobj);
                System.out.println(map);

            } else {
                mystockobj.setStockQuantity(map.getOrDefault(orderobj.getStockId(), mystockobj).stockQuantity - orderobj.getOrderQuantity());
                map.put(orderobj.getStockId(), mystockobj);
                System.out.println(map);
            }
        }


    }
        for(
    Integer myorder :uniqueorder)

    {
        mystocklist.add(map.get(myorder));
    }
        return mystocklist;
}

    @Override
    public List<Order> orderAvailable(int id) {
        return  orderRepository.findAll().stream().filter(a -> a.getCustId() == id).collect(Collectors.toList());
    }
}
