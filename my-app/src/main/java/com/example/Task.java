package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean completed;
    //priority field
    private String priority;

    // fundamentally, variable needs getter and Setter
    // Getters and Setters(priority)
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    // Getters and Setters(id)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getters and Setters(name)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
