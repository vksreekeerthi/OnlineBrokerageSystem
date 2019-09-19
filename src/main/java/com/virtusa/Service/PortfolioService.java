package com.virtusa.Service;

import com.virtusa.Entity.Order;
import com.virtusa.Entity.mystock;

import java.util.List;

public interface PortfolioService {
    public List<mystock> stocksAvailable(int id);
    public List<Order> orderAvailable(int id);
}
