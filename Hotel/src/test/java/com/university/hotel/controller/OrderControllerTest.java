package com.university.hotel.controller;

import com.university.hotel.entities.Order;
import com.university.hotel.repos.OrderRepo;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OrderControllerTest {

    @Test(expected = java.lang.NullPointerException.class)
    public void reserveRoomTest(){
        OrderController orderController = new OrderController(null,null);
        orderController.reserveRoom(null,null,null,null);
    }

    @Test
    public void allOrdersTest(){
        OrderRepo orderRepo = Mockito.mock(OrderRepo.class);
        Mockito.when(orderRepo.findAll()).thenReturn(Collections.singleton(new Order()));
        OrderController orderController = new OrderController(orderRepo,null);
        Map<String,Object> model= new HashMap<>();
        orderController.allOrders(model);
        Assert.assertEquals(1,((Collection<Object>)model.get("orders")).size());
    }
}
