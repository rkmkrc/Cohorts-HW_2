package org.erkam;

import org.erkam.model.Customer;
import org.erkam.model.Invoice;
import org.erkam.service.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        // Müşteri ve fatura örnekleri oluşturma
        Customer customer1 = new Customer("Alice", LocalDate.of(2023, 6, 15), "IT", new ArrayList<>());
        Customer customer2 = new Customer("Bob", LocalDate.of(2023, 5, 20), "Construction", new ArrayList<>());
        Customer customer3 = new Customer("Charlie", LocalDate.of(2023, 6, 10), "Healthcare", new ArrayList<>());

        Invoice invoice1 = new Invoice(1000, LocalDate.of(2023, 6, 5));
        Invoice invoice2 = new Invoice(2000, LocalDate.of(2023, 5, 15));
        Invoice invoice3 = new Invoice(500, LocalDate.of(2023, 6, 20));
        Invoice invoice4 = new Invoice(250, LocalDate.of(2023, 6, 25));
        Invoice invoice5 = new Invoice(3000, LocalDate.of(2023, 4, 15));

        customer1.addInvoice(invoice1);
        customer1.addInvoice(invoice3);
        customer2.addInvoice(invoice2);
        customer3.addInvoice(invoice4);
        customer3.addInvoice(invoice5);

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);

        // Tüm müşterileri listeleme
        System.out.println("All customers: " + customerService.getAllCustomers());

        // 'C' harfi içeren müşterileri listeleme
        System.out.println("Customers containing 'C': " + customerService.getCustomersContainingC());

        // Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı
        System.out.println("Total invoice amount in June: " + customerService.getTotalInvoicesAmountInJune());

        // Sistemdeki tüm faturaları listeleme
        System.out.println("All invoices: " + customerService.getAllInvoices());

        // 1500 TL üstündeki faturaları listeleme
        System.out.println("Invoices above 1500: " + customerService.getInvoicesAbove1500());

        // 1500 TL üstündeki faturaların ortalamasını hesaplama
        System.out.println("Average invoice above 1500: " + customerService.getAverageInvoiceAbove1500());

        // 500 TL altındaki faturalara sahip müşterilerin isimlerini listeleme
        System.out.println("Customers with invoices below 500: " + customerService.getCustomerNamesWithInvoicesBelow500());

        // Haziran ayının faturaları ortalaması 750 altı olan firmaların sektörlerini listeleme
        System.out.println("Sectors with June invoices average below 750: " + customerService.getSectorsWithJuneInvoicesAverageBelow750());
    }
}