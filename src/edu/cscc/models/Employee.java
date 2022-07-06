package edu.cscc.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private Integer id;

    private String activeStoreNumber;

    private String firstName;

    private String lastName;

    private List<Order> orders;

    public Employee() {
        super();
        orders = new ArrayList<>();
    }

    public Employee(String activeStoreNumber, String firstName, String lastName) {
        this.activeStoreNumber = activeStoreNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        orders = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActiveStoreNumber() {
        return activeStoreNumber;
    }

    public void setActiveStoreNumber(String activeStoreNumber) {
        this.activeStoreNumber = activeStoreNumber;
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
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(activeStoreNumber, employee.activeStoreNumber) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(orders, employee.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activeStoreNumber, firstName, lastName, orders);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", activeStoreNumber='" + activeStoreNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employees=" + orders +
                '}';
    }
}
