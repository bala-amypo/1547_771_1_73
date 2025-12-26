package com.example.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HibernateQueryUtil {

    private HibernateQueryUtil() {
        // Utility class
    }

    // ----------------------------------------------------
    // Create typed query
    // ----------------------------------------------------
    public static <T> TypedQuery<T> createQuery(
            EntityManager entityManager,
            String hql,
            Class<T> resultClass) {

        return entityManager.createQuery(hql, resultClass);
    }

    // ----------------------------------------------------
    // Execute query and return list
    // ----------------------------------------------------
    public static <T> List<T> getResultList(TypedQuery<T> query) {
        return query.getResultList();
    }
}
