package com.teresa.ubicua.repository;

import com.teresa.ubicua.entity.Address;
import com.teresa.ubicua.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneMappingTest {
    @Autowired
    private OrderRepository orderRepository;
    @Test
    void SaveMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("10000ABC");
        order.setTotalQuantity(5);
        order.setTotalPrice(new BigDecimal(100));
        order.setStatus("In Process");

        Address address = new Address();
        address.setCity("Santa Cruz de la Sierra");
        address.setCountry("Bolivia");
        address.setState("Santa Cruz");
        address.setStreet("Calle Diego de Mendoza 373");
        address.setZipCode("00000");
        order.setBillingAddress(address);

        orderRepository.save(order);
    }
    @Test
    void updateMethod(){
        Order order = orderRepository.findById(1L).get();
        order.setStatus("Entregado");
        order.getBillingAddress().setZipCode("11111"); //get consigo y set actualizo

        orderRepository.save(order);
    }
}


