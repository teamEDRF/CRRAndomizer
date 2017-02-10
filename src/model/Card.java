/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Model to card objects
 *
 * @author santi
 */
public class Card {

    private int id;
    private String name;
    private String url;

    public String getUrl() {
        return url;
    }

    public Card(String name, int id) {
        setName(name);
        this.id = id;
    }

    public Card() {
    }

    public Card(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.url = "./assets/images/" + name.replace(" ", "_") + ".png";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "-" + name + '}';
    }

}
