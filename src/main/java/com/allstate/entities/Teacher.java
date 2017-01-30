package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name ="teachers")

public class Teacher {
    private int id;
    private int version;
    private String name;
    private Gender gender;
    private int age;
    private int klass_id;
    private Date created;
    private Date modified;
    private Klass klass;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @NotNull
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @NotNull
    @Enumerated(EnumType.STRING)
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}

    @NotNull
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @ManyToOne
    @JoinColumn(name="klass_id")
    @JsonIgnore
    public Klass getKlass() {return klass;}
    public void setKlass(Klass klass) {this.klass = klass;}
}




