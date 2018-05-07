package com.job.dto;

public class JobDTO {
    public Integer getId() {
        return Id;
    }

    public JobDTO() {

    }

    public JobDTO(Integer id, String name, String status) {
        Id = id;
        Name = name;
        Status = status;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    private Integer Id;
    private String Name;
    private String Status;
}
