package org.erkam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Invoice {
    private double amount;
    private LocalDate date;
}
