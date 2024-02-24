package com.teresa.ubicua.repository;

import com.teresa.ubicua.entity.Address;
import com.teresa.ubicua.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
@SpringBootTest
public class OneToOneBidirectionalMappingTest {
    @Autowired
    private AddressRepository addressRepository;
    @Test
    void saveAddressMethod(){
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
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod(){
        Address address1 = addressRepository.findById(1L).get();
        address1.setZipCode("99999");
        address1.getOrder().setStatus("Entregado");

        addressRepository.save(address1);
    }
}
