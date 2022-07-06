package edu.cscc.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rental {

    private Integer id;

    private String name;

    private List<OrderLineItem> orderLineItems;

    public Rental() {
        orderLineItems = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) &&
                Objects.equals(name, rental.name) &&
                Objects.equals(orderLineItems, rental.orderLineItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orderLineItems);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderLineItems=" + orderLineItems +
                '}';
    }
}
