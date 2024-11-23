package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SalesReportSystem {

    public static void main(String[] args) {

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale("Laptop", 1200.00, "Electronics", LocalDate.of(2024, 11, 1)));
        sales.add(new Sale("Smartphone", 800.00, "Electronics", LocalDate.of(2024, 11, 2)));
        sales.add(new Sale("Headphones", 150.00, "Accessories", LocalDate.of(2024, 11, 3)));
        sales.add(new Sale("Keyboard", 100.00, "Accessories", LocalDate.of(2024, 11, 4)));
        sales.add(new Sale("Fridge", 900.00, "Appliances", LocalDate.of(2024, 11, 5)));
        sales.add(new Sale("Microwave", 300.00, "Appliances", LocalDate.of(2024, 11, 6)));

        SalesReport report = new SalesReport();


        report.generateReport(sales);
        report.generateReport(sales, "Electronics");
        report.generateReport(sales, LocalDate.of(2024, 11, 2), LocalDate.of(2024, 11, 4));
    }

}



record Sale (String productName,double productPrice, String productCategory, LocalDate date) {

}


class SalesReport {


    public void generateReport(List<Sale> sales) {
        double totalRevenue = calculateTotalRevenue(sales, sale -> true); // No filter
        double averageSales = calculateAverage(sales, sale -> true);

        System.out.println("Full Sales Report:");
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Sales: $" + averageSales);
        System.out.println();
    }


    public void generateReport(List<Sale> sales, String productCategory) {
        double totalRevenue = calculateTotalRevenue(sales, sale -> sale.productCategory().equalsIgnoreCase(productCategory));
        double averageSales = calculateAverage(sales, sale -> sale.productCategory().equalsIgnoreCase(productCategory));

        System.out.println("Sales Report for Category: " + productCategory);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Sales: $" + averageSales);
        System.out.println();
    }


    public void generateReport(List<Sale> sales, LocalDate startDate, LocalDate endDate) {
        Predicate<Sale> dateRangeFilter = sale ->
                (sale.date().isEqual(startDate) || sale.date().isAfter(startDate)) &&
                        (sale.date().isEqual(endDate) || sale.date().isBefore(endDate));

        double totalRevenue = calculateTotalRevenue(sales, dateRangeFilter);
        double averageSales = calculateAverage(sales, dateRangeFilter);

        System.out.println("Sales Report for Date Range: " + startDate + " to " + endDate);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Sales: $" + averageSales);
        System.out.println();
    }


    private double calculateTotalRevenue(List<Sale> sales, Predicate<Sale> filter) {
        double total = 0.0;
        for (Sale sale : sales) {
            if (filter.test(sale)) {
                total += sale.productPrice();
            }
        }
        return total;
    }


    private double calculateAverage(List<Sale> sales, Predicate<Sale> filter) {
        double total = 0.0;
        int count = 0;
        for (Sale sale : sales) {
            if (filter.test(sale)) {
                total += sale.productPrice();
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }
}
