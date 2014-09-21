package com.pretech;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "hibernate_schema")
public class Student {

    @Id
    @Column(name = "name", unique = true, nullable = false, length = 10)
    private String name;

    @Column(name = "standard", unique = true, nullable = false, length = 20)
    private String standard;


    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String string) {
        name = string;
    }

    public String toString() {
        return name;
    }

}