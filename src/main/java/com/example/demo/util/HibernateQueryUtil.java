// // package com.example.demo.util;

// // import com.example.demo.model.ApprovalAction;
// // import jakarta.persistence.EntityManager;
// // import jakarta.persistence.PersistenceContext;
// // import jakarta.persistence.criteria.CriteriaBuilder;
// // import jakarta.persistence.criteria.CriteriaQuery;
// // import jakarta.persistence.criteria.Root;
// // import org.springframework.stereotype.Component;

// // import java.util.ArrayList;
// // import java.util.List;

// // @Component
// // public class HibernateQueryUtil {

// //     @PersistenceContext
// //     private EntityManager entityManager;

// //     public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
// //         if (approverId == null) {
// //             return new ArrayList<>();
// //         }
// //         CriteriaBuilder cb = entityManager.getCriteriaBuilder();
// //         CriteriaQuery<ApprovalAction> cq = cb.createQuery(ApprovalAction.class);
// //         Root<ApprovalAction> root = cq.from(ApprovalAction.class);
        
// //         cq.select(root).where(cb.equal(root.get("approverId"), approverId));
        
// //         return entityManager.createQuery(cq).getResultList();
// //     }
// // }




// package com.example.demo.util;

// import com.example.demo.model.ApprovalAction;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.criteria.*;
// import org.springframework.stereotype.Component;

// import java.util.List;

// @Component
// public class HibernateQueryUtil {

//     @PersistenceContext
//     private EntityManager em;

//     public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
//         CriteriaBuilder cb = em.getCriteriaBuilder();
//         CriteriaQuery<ApprovalAction> cq = cb.createQuery(ApprovalAction.class);
//         Root<ApprovalAction> root = cq.from(ApprovalAction.class);

//         if (approverId != null) {
//             cq.where(cb.equal(root.get("approverId"), approverId));
//         }

//         return em.createQuery(cq).getResultList();
//     }
// }



package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import java.util.List;

@Component
@Transactional
public class HibernateQueryUtil {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
        if (approverId == null) {
            return List.of();
        }
        
        Session session = entityManager.unwrap(Session.class);
        Query<ApprovalAction> query = session.createQuery(
            "FROM ApprovalAction a WHERE a.approverId = :approverId", 
            ApprovalAction.class);
        query.setParameter("approverId", approverId);
        return query.getResultList();
    }
}
