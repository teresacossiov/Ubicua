//TENER PRODUCTOS PARA PODER CORRER LA PRUEBA
package com.teresa.ubicua.repository;

import com.teresa.ubicua.entity.Address;
import com.teresa.ubicua.entity.Order;//Ponerlo asi para poder instanciar
import com.teresa.ubicua.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyUnidirectionalMappingTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("200ABC");
        order.setStatus("IN PROGRESS");

        //CREAR LOS ITEMS
        //EL PRIMER ITEM
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(productRepository.findById(1L).get());
        orderItem.setQuantity(2);
        orderItem.setPrice(orderItem
                .getProduct()
                .getPrice()
                .multiply(new BigDecimal(1)));
        orderItem.setImgUrl("imagen1.png");
        order.getOrderItems().add(orderItem);

        //crear el 2do item
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(2L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1
                .getProduct()
                .getPrice()
                .multiply(new BigDecimal(2)));
        orderItem1.setImgUrl("imagen2.png");
        order.getOrderItems().add(orderItem1);

        //conseguir el total de pedidos en plata
        order.setTotalPrice(order.getTotalAmount());
        //sumar los items que tiene el pedido
        order.setTotalQuantity(2);

        //CREAMOS LA DIRECCION
        Address address3 = new Address();
        address3.setCity("Santa Cruz de la Sierra");
        address3.setCountry("Bolivia");
        address3.setState("Santa Cruz");
        address3.setStreet("Calle Diego de Mendoza 373");
        address3.setZipCode("00000");

        order.setBillingAddress(address3);
        orderRepository.save(order);
    }

}
