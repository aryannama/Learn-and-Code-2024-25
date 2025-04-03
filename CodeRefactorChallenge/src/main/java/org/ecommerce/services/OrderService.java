package org.ecommerce.services;

import org.ecommerce.constants.Membership;
import org.ecommerce.model.Customer;
import org.ecommerce.model.Order;
import org.ecommerce.model.OrderItem;
import org.ecommerce.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.ecommerce.constants.Discount.*;
import static org.ecommerce.constants.Errors.*;
import static org.ecommerce.constants.Messages.*;
import static org.ecommerce.constants.OrderStatus.CANCELLED;
import static org.ecommerce.constants.OrderStatus.PROCESSING;
import static org.ecommerce.services.CustomerService.customers;
import static org.ecommerce.services.ProductService.products;

public class OrderService {
    private static List<Order> activeOrders = new ArrayList<>();
    private static List<String> processingQueue = new ArrayList<>();
    public static Map<String, Order> orderDatabase = new HashMap<>();

    private ProductService productService = new ProductService();

    public boolean processOrder(String orderId) {
        System.out.println(String.format(PROCESSING_ORDER, orderId));

        Order order = validateOrder(orderId);
        if (order == null) {
            return false;
        }

        Customer customer = validateCustomer(order.getCustomerId());
        if (customer == null) {
            return false;
        }

        if (!isValidOrder(order)) {
            return false;
        }

        productService.updateProductStock(order, false);
        double discount = calculateDiscount(customer, order);

        order.setStatus(PROCESSING);
        order.setDiscountApplied(order.getTotalAmount() * discount);
        order.setFinalAmount(order.getTotalAmount() - order.getDiscountApplied());
        order.setUpdatedAt(LocalDateTime.now());

        orderDatabase.put(orderId, order);
        activeOrders.add(order);
        processingQueue.add(orderId);

        NotificationService.sendCustomerNotification(customer.getEmail(),
                String.format(ORDER_BEING_PROCESSED, orderId));
        NotificationService.sendAdminNotification(String.format(NEW_ORDER_PROCESSING, orderId));

        return true;
    }

    public boolean cancelOrder(String orderId) {
        System.out.println(String.format(CANCELLING_ORDER, orderId));

        Order order = validateOrder(orderId);
        if (order == null) {
            return false;
        }

        Customer customer = validateCustomer(order.getCustomerId());
        if (customer == null) {
            return false;
        }

        productService.updateProductStock(order, true);

        order.setStatus(CANCELLED);
        order.setUpdatedAt(LocalDateTime.now());

        orderDatabase.put(orderId, order);
        activeOrders.removeIf(o -> o.getId().equals(orderId));
        processingQueue.removeIf(id -> id.equals(orderId));

        NotificationService.sendCustomerNotification(customer.getEmail(), String.format(ORDER_CANCELLED, orderId));
        NotificationService.sendAdminNotification(String.format(ORDER_CANCELLED, orderId));

        return true;
    }

    private Order validateOrder(String orderId) {
        Order order = orderDatabase.get(orderId);
        if (order == null) {
            System.out.println(ORDER_NOT_FOUND);
        }
        return order;
    }

    private Customer validateCustomer(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println(CUSTOMER_NOT_FOUND);
        }
        return customer;
    }

    private boolean isValidOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            Product product = products.get(item.getProductId());
            if (product == null) {
                System.out.println(String.format(PRODUCT_NOT_FOUND, item.getProductId()));
                return false;
            }
            if (product.getStock() < item.getQuantity()) {
                System.out.println(String.format(INSUFFICIENT_STOCK, item.getProductId()));
                return false;
            }
        }
        return true;
    }

    private double calculateDiscount(Customer customer, Order order) {
        double discount = 0;
        Membership membership = Membership.valueOf(customer.getMembershipLevel().toUpperCase());

        switch (membership) {
            case GOLD:
                discount = GOLD_DISCOUNT;
                break;
            case PLATINUM:
                discount = PLATINUM_DISCOUNT;
                break;
            case DIAMOND:
                discount = DIAMOND_DISCOUNT;
                break;
        }

        if (order.getTotalAmount() > ADDITIONAL_DISCOUNT_PRICE) {
            discount += ADDITIONAL_DISCOUNT;
        }
        return discount;
    }
}
