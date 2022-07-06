package edu.cscc.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_line_items")
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Rental rental;

    @ManyToOne
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
