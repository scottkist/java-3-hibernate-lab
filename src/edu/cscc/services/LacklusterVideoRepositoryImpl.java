package edu.cscc.services;

import edu.cscc.exceptions.LacklusterVideoServiceException;
import edu.cscc.models.Order;

import java.util.List;

public class LacklusterVideoRepositoryImpl implements LacklusterVideoRepository {

    @Override
    public List<Order> getOrders() throws LacklusterVideoServiceException {
        return null;
    }

    @Override
    public void createOrder(Integer employeeId, Integer customerId, List<Integer> rentalIds) throws LacklusterVideoServiceException {

    }

    @Override
    public void deleteOrders() throws LacklusterVideoServiceException {

    }
}
