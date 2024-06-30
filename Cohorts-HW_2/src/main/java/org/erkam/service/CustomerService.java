package org.erkam.service;

import org.erkam.model.Customer;
import org.erkam.model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public List<Customer> getCustomersContainingC() {
        return customers.stream()
                .filter(customer -> customer.getName().contains("C"))
                .collect(Collectors.toList());
    }

    public double getTotalInvoicesAmountInJune() {
        return customers.stream()
                .flatMap(customer -> customer.getInvoices().stream())
                .filter(invoice -> invoice.getDate().getMonthValue() == 6)
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    public List<Invoice> getAllInvoices() {
        return customers.stream()
                .flatMap(customer -> customer.getInvoices().stream())
                .collect(Collectors.toList());
    }

    public List<Invoice> getInvoicesAbove1500() {
        return getAllInvoices().stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .collect(Collectors.toList());
    }

    public double getAverageInvoiceAbove1500() {
        return getInvoicesAbove1500().stream()
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    public List<String> getCustomerNamesWithInvoicesBelow500() {
        return customers.stream()
                .filter(customer -> customer.getInvoices().stream().anyMatch(invoice -> invoice.getAmount() < 500))
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    public List<String> getSectorsWithJuneInvoicesAverageBelow750() {
        Map<String, List<Invoice>> sectorInvoices = customers.stream()
                .collect(Collectors.groupingBy(Customer::getSector,
                        Collectors.flatMapping(customer -> customer.getInvoices().stream(), Collectors.toList())));

        return sectorInvoices.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .filter(invoice -> invoice.getDate().getMonthValue() == 6)
                        .mapToDouble(Invoice::getAmount)
                        .average()
                        .orElse(0) < 750)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}