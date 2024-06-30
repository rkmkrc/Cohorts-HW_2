package org.erkam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private LocalDate registrationDate;
    private String sector;
    private List<Invoice> invoices = new ArrayList<>();

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }
}