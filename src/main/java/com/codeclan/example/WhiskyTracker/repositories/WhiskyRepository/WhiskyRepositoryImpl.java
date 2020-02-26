package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findByDistilleryAndAge(Long id, int age){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Whisky.class);
            criteria.add(Restrictions.eq("distillery.id", id));
            criteria.add(Restrictions.eq("age", age));

            result = criteria.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Transactional //This is not working... It can't access distillery.region.
    public List<Whisky> findByRegion(String region){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Whisky.class);

            criteria.add(Restrictions.eq("distillery.region", region));

            result = criteria.list();

        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
