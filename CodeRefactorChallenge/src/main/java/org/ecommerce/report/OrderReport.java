package org.ecommerce.report;

import org.ecommerce.model.Customer;
import org.ecommerce.model.Order;
import org.ecommerce.services.CustomerService;
import org.ecommerce.services.OrderService;

import java.time.LocalDateTime;

import static org.ecommerce.constants.OrderStatus.CANCELLED;

public class OrderReport {
    public String generateOrderReport(LocalDateTime startDate, LocalDateTime endDate) {
        StringBuilder report = new StringBuilder("Order Report\n");
        int totalOrders = 0;
        double totalRevenue = 0;

        for (Order order : OrderService.orderDatabase.values()) {
            if (isOrderWithinDateRange(order, startDate, endDate)) {
                if (order.getStatus() != CANCELLED) {
                    totalOrders++;
                    totalRevenue += order.getFinalAmount();
                    appendOrderDetails(report, order);
                }
            } else {
                throw new RuntimeException("Order not found within date range: " + startDate + " - " + endDate);
            }
        }

        appendSummary(report, totalOrders, totalRevenue);
        return report.toString();
    }

    private boolean isOrderWithinDateRange(Order order, LocalDateTime startDate, LocalDateTime endDate) {
        return order.getCreatedAt().isAfter(startDate) && order.getCreatedAt().isBefore(endDate);
    }

    private void appendOrderDetails(StringBuilder report, Order order) {
        Customer customer = CustomerService.customers.get(order.getCustomerId());
        if (customer != null) {
            report.append("\nOrder ID: ").append(order.getId())
                    .append("\nCustomer: ").append(customer.getName())
                    .append("\nAmount: $").append(String.format("%.2f", order.getFinalAmount()))
                    .append("\nStatus: ").append(order.getStatus())
                    .append("\n-------------------");
        }
    }

    private void appendSummary(StringBuilder report, int totalOrders, double totalRevenue) {
        report.append("\n\nTotal Orders: ").append(totalOrders)
                .append("\nTotal Revenue: $").append(String.format("%.2f", totalRevenue));
    }
}
