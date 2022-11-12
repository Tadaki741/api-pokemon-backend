package com.pokemon.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "image_front", columnDefinition = "TEXT" , length = 500)
    private String image_front;

    @Column(name = "image_back", columnDefinition = "TEXT" , length = 500)
    private String image_back;
    private int quantity;

    public Pokemon(String name, String imagefront, String imageback, int quantity) {
        this.name = name;
        this.image_front = imagefront;
        this.image_back = imageback;
        this.quantity = quantity;
    }

    public Pokemon() {
    }

    //Important to have id getter, otherwise the frontend will not receive the id to perform REST request back to
    //backend
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_front() {
        return image_front;
    }

    public void setImage_front(String image_front) {
        this.image_front = image_front;
    }

    public String getImage_back() {
        return image_back;
    }

    public void setImage_back(String image_back) {
        this.image_back = image_back;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image_front='" + image_front + '\'' +
                ", image_back='" + image_back + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
