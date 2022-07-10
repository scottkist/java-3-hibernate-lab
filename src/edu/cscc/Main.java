package edu.cscc;

import edu.cscc.models.Customer;
import edu.cscc.models.Order;
import edu.cscc.models.OrderLineItem;
import edu.cscc.mvc.framework.MVCContext;
import edu.cscc.mvc.framework.Request;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        //Testing First Commit2
        MVCContext mvcContext = new MVCContext("edu.cscc.controllers");
        try {
            mvcContext.processRequest(new Request("Home", "index"));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
