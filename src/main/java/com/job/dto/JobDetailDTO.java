package com.job.dto;

public class JobDetailDTO {
    public JobDetailDTO () {

    }

    public JobDetailDTO(Integer id, String name, String description, String status) {
        Id = id;
        Name = name;
        Description = description;
        Status = status;
    }

    public Integer getId() {
        return Id;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    private Integer Id;
    private String Name;
    private String Description;
    private String Status;

}
