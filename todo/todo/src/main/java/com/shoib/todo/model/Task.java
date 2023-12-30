package com.shoib.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity @Table(name = "tasks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String  title;
    @Column(name = "task")
    private String task;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "repeating")
    private boolean repeating;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTask() {
        return task;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isRepeating() {
        return repeating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setRepeating(boolean repeating) {
        this.repeating = repeating;
    }

    public Task() {}
    public Task(Long id, String title, String task, Date startDate, Date endDate, boolean repeating) {
        this.id = id;
        this.title = title;
        this.task = task;
        this.startDate = startDate;
        this.endDate = endDate;
        this.repeating = repeating;
    }


}
