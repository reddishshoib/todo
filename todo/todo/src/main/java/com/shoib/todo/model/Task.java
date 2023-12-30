package com.shoib.todo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity @Table(name = "tasks")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title", nullable = false)
    private long title;
    @Column(name = "task")
    private long task;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "repeating")
    private boolean repeating;
}
