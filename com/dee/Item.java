package com.dee;

import java.io.Serializable;

 class Item implements Serializable {
     private static final long serialVersionUID = 6911960776796077126L;
    int id;
    String name;
    int quantity;
    String date;

    public Item(int id, String name, int quantity, String date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}
