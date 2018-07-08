package com.job.dto;

public class JobDTO {
    public int getId() {
        return id;
    }

    public JobDTO() {

    }

    public JobDTO(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int id;
    private String name;
    private String status;
}
