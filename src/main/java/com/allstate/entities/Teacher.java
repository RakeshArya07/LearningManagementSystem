package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="teachers")
@Data
public class Teacher {
    private int id;
    private int version;
    private String name;
    private Gender gender;
    private int age;
    private Date created;
    private Date modified;
    private List<Klass> klasses;

    public Teacher(){}

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


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    @JsonIgnore
    public List<Klass> getKlasses() {return klasses;}
    public void setKlasses(List<Klass> klasses) {this.klasses = klasses;}
}




