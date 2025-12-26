package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HibernateQueryUtil {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Required for testCriteriaFindActionsByApprover and testCriteriaEdgeCaseNullApprover.
     * Uses Hibernate Criteria API (HCQL).
     */
    public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
        if (approverId == null) {
            return new ArrayList<>();
        }

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ApprovalAction> query = cb.createQuery(ApprovalAction.class);
        Root<ApprovalAction> root = query.from(ApprovalAction.class);

        query.select(root).where(cb.equal(root.get("approverId"), approverId));

        return entityManager.createQuery(query).getResultList();
    }
}