package com.staffplanner.checkout.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "wishes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public enum Shift {
        EARLY,  // 7:00 AM – 3:30 PM
        LATE    // 11:30 AM – 8:00 PM
    }
}