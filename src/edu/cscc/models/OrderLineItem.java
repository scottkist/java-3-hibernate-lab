package edu.cscc.models;

import java.util.Objects;

public class OrderLineItem {

    private Integer id;

    private Rental rental;

    private Order order;

    public OrderLineItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineItem that = (OrderLineItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rental, that.rental) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rental, order);
    }

    @Override
    public String toString() {
        return "OrderLineItem{" +
                "id=" + id +
                ", rental=" + rental +
                ", order=" + order +
                '}';
    }
}
