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
    private String description; 
    private boolean completed;
    //priority field
    private String priority;
    private String date;


    // fundamentally, variable needs getter and Setter
    // getはuserの入力を受けるため、String ~(), setはvoid ~(変数名)

    // Getters and Setters(priority)
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    // Getters and Setters(id)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getters and Setters(name)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Getters and Setters(date)
    public String getDate() { return date; }
    public void setDate(String date) {this.date = date; }

    // Getters and Setters(project descriptions)
    public String getDescription() { return description; }
    public void setDescription(String description) {this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
