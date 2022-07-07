package edu.cscc.services;

import edu.cscc.exceptions.LacklusterVideoServiceException;
import edu.cscc.models.Order;
import edu.cscc.models.OrderLineItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class LacklusterVideoRepositoryImpl implements LacklusterVideoRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LacklusterVideo");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<Order> getOrders() throws LacklusterVideoServiceException {
        List<Order> orders = new ArrayList<>();
        String testQuery = "Select o from Order o";
        Query query = entityManager.createQuery(testQuery);
        orders = query.getResultList();

        return orders;
    }

    @Override
    public void createOrder(Integer employeeId, Integer customerId, List<Integer> rentalIds) throws LacklusterVideoServiceException {

    }

    @Override
    public void deleteOrders() throws LacklusterVideoServiceException {

    }
}
