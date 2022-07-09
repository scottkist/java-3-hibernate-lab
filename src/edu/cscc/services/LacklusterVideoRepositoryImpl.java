package edu.cscc.services;

import edu.cscc.exceptions.LacklusterVideoServiceException;
import edu.cscc.models.Employee;
import edu.cscc.models.Order;
import edu.cscc.models.OrderLineItem;
import javax.persistence.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LacklusterVideoRepositoryImpl implements LacklusterVideoRepository {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public LacklusterVideoRepositoryImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("LacklusterVideo");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

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
        /////////////////////////////////////////////////////////////// This is working
        try {
            List<Order> orderIds = new ArrayList<>();
            entityManager.getTransaction().begin();
            Query sqlQuery = entityManager.createNativeQuery("insert into orders (employee_id, customer_id, store_number) values (:employeeId, :customerId, :storeNumber)");
            sqlQuery.setParameter("employeeId", employeeId);
            sqlQuery.setParameter("customerId", customerId);
            sqlQuery.setParameter("storeNumber", Order.DEFAULT_STORE_NUMBER );
            sqlQuery.executeUpdate();
            entityManager.getTransaction().commit();
            /////////////////////////////////////////////////////////////
            //TODO: Get Order ID - Previous lab did Order by Dec and Limited by 1. SO trying the same solution..
            Query queryForOrderId = entityManager.createNativeQuery("SELECT id From orders ORDER BY id DESC LIMIT 1");
            orderIds = queryForOrderId.getResultList();
            Integer test = ((Integer)orderIds.get(0)
            );
            System.out.println("testing");


                for (int i = 0; i < rentalIds.size(); i++) {
                    Query sqlCreateOLI = entityManager.createNativeQuery("insert into order_line_items (order_id, rental_id) values (:orderId, :rentalId)");


//                    sqlCreateOLI.setParameter("orderId", orderIds.get(1));
                    sqlCreateOLI.setParameter("rentalId", rentalIds.get(i));
                    sqlCreateOLI.executeUpdate();
                    entityManager.getTransaction().commit();
            }

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
