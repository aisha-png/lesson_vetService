package com.bnta.vetservice.models;

import javax.persistence.*;

//Annotation to tell it we want it to be a table = Entity
@Entity//let's hibernate know we want to map to a database table
@Table
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name ="vet_id", nullable = false)
    private Vet vet;


    public Pet(String name, String type, Vet vet) {
        this.name = name;
        this.type = type;
        this.vet = vet;
    }

    public Pet() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
