package com.bnta.vetservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "vet")//mapped by = name of the property in 'Pet; that's not to be FK
    @JsonIgnoreProperties({"vet"})
    private List<Pet> pets;

    public Vet(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public Vet() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
