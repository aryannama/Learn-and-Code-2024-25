package org.ecommerce;

import org.ecommerce.model.Customer;
import org.ecommerce.model.Order;
import org.ecommerce.model.OrderItem;
import org.ecommerce.model.Product;
import org.ecommerce.services.CustomerService;
import org.ecommerce.services.OrderService;
import org.ecommerce.services.ProductService;

import java.time.LocalDateTime;

import static org.ecommerce.constants.OrderStatus.*;
import static org.ecommerce.services.OrderService.orderDatabase;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();

        Customer customer = new Customer();
        customer.setId("CUST1");
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setAddress("123 Main St");
        customer.setPhone("555-0123");
        customer.setMembershipLevel("gold");

        Product product = new Product();
        product.setId("PROD1");
        product.setName("Widget");
        product.setPrice(99.99);
        product.setDescription("A fantastic widget");
        product.setCategory("gadgets");
        product.setStock(100);

        customerService.addCustomer(customer);
        productService.addProduct(product);

        String orderId = "ORD123";
        Order order = new Order();
        order.setId(orderId);
        order.setCustomerId("CUST1");
        order.setStatus(PENDING);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        order.setTotalAmount(199.98);

        OrderItem item = new OrderItem();
        item.setProductId("PROD1");
        item.setQuantity(2);
        item.setPrice(99.99);
        order.getItems().add(item);

        orderDatabase.put(orderId, order);
        boolean result = orderService.processOrder(orderId);
        System.out.println("Order processing " + (result ? SUCCEEDED : FAILED));
    }
}
