package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findAllWith12YearOldWhisky(){
        List<Distillery> result = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Distillery.class);
            criteria.createAlias("whiskies", "whiskyAlias");
            criteria.add(Restrictions.eq("whiskyAlias.age", 12));

            result = criteria.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        }

        return result;
    }



}
