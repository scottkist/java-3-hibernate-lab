package edu.cscc.services;

import edu.cscc.exceptions.LacklusterVideoServiceException;
import edu.cscc.models.Employee;
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
        String selectQuery = "Select o from Order o";
        Query query = entityManager.createQuery(selectQuery);
        orders = query.getResultList();

        return orders;
    }

    @Override
    public void createOrder(Integer employeeId, Integer customerId, List<Integer> rentalIds) throws LacklusterVideoServiceException {
        try {
            entityManager.getTransaction().begin();
            Query sqlQuery = entityManager.createQuery("test");


            } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
            throw new LacklusterVideoServiceException("Could not create order");
        }
    }

    @Override
    public void deleteOrders() throws LacklusterVideoServiceException {
        try {
            entityManager.getTransaction().begin();
            Query deleteQuery1 = entityManager.createQuery("delete from OrderLineItem");
            Query deleteQuery2 = entityManager.createQuery("delete from Order");
            deleteQuery1.executeUpdate();
            deleteQuery2.executeUpdate();
            entityManager.getTransaction().commit();

        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
            throw new LacklusterVideoServiceException("Could not delete orders.");
        }
    }
}
