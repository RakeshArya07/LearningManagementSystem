package com.allstate.entities;


import com.allstate.enums.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "klasses")

public class Klass {
    private int id;
    private int version;
    private String name;
    private Date semester;
    private int credits;
    private Department department;
    private double fee;
    private Date created;
    private Date modified;
    private List<Teacher> teachers;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @Enumerated(EnumType.STRING)
    @NotNull
    public Department getDepartment() {return department;}
    public void setDepartment(Department department) {this.department = department;}

    @Size(min = 2)
    @NotNull
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @NotNull
    public Date getSemester() {return semester;}
    public void setSemester(Date semester) {this.semester = semester;}

    @NotNull
    public int getCredits() {return credits;}
    public void setCredits(int credits) {this.credits = credits;}

    @NotNull
    public double getFee() {return fee;}
    public void setFee(double fee) {this.fee = fee;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klasses")
    @JsonIgnore
    public List<Teacher> getTeachers() {return teachers;}
    public void setTeachers(List<Teacher> teachers) {this.teachers = teachers;}
}





