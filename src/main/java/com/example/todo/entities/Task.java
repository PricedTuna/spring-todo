package com.example.todo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Task {
    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
}
