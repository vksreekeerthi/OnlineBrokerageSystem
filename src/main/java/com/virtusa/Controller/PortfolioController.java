package com.virtusa.Controller;

import com.virtusa.DAO.OrderRepository;
import com.virtusa.Entity.Order;
import com.virtusa.Entity.mystock;

import com.virtusa.Service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/stockapi/v1/portfolio")
public class PortfolioController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public List<mystock> stocksAvailable(@PathVariable int id) {

        return portfolioService.stocksAvailable(id);

    }

    @RequestMapping(value="/{id}/history", method=RequestMethod.GET)
    public List<Order> historyOfStocks(@PathVariable int id)
    {
        return portfolioService.orderAvailable(id);
    }

}
