package edu.cscc.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Integer id;

    private String smartId;

    private String firstName;

    private String lastName;

    private List<Order> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public Customer(String firstName, String lastName, String smartId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.smartId = smartId;
        orders = new ArrayList<>();
    }

    public Customer(Integer id, String firstName, String lastName, String smartId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.smartId = smartId;
        orders = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmartId() {
        return smartId;
    }

    public void setSmartId(String smartId) {
        this.smartId = smartId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(smartId, customer.smartId) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smartId, firstName, lastName, orders);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", smartId='" + smartId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
