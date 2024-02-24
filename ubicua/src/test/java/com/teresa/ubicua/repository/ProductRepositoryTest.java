package com.teresa.ubicua.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.teresa.ubicua.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //Creating the product
        Product product = new Product();
        product.setName("Bollo");
        product.setDescription("El mejor pollo de Santa Cruz");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(25));
        product.setUrlImage("producto.png");

        //Saving the product
        Product objProduct = productRepository.save(product);
        System.out.println(objProduct.getId());
        System.out.println(objProduct.toString());
    }

   @Test
   void updateMethod(){
        //Encontrar un producto por medio de su id
       Long id = 1L;
       Product product = productRepository.findById(id).get();

       //Actualizar el producto
       product.setName("Product 1 Update");
       product.setDescription("Product 1 Description Update");

       //Grabar producto actualizado
       productRepository.save(product);

    }

    @Test
    void saveAllMethod(){
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("Product 1 description");
        product1.setSku("200ABC");
        product1.setPrice(new BigDecimal(30));
        product1.setActive(true);
        product1.setUrlImage("producto1.png");

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("300ABC");
        product2.setPrice(new BigDecimal(30));
        product2.setActive(true);
        product2.setUrlImage("producto2.png");

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("400ABC");
        product3.setPrice(new BigDecimal(30));
        product3.setActive(true);
        product3.setUrlImage("producto3.png");

        productRepository.saveAll(List.of(product1, product2, product3));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteMethod(){
        Long id = 5L;
        productRepository.deleteById(id);
    }
}