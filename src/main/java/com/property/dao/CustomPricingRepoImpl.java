package com.property.dao;

import com.property.dto.Listing;
import com.property.dto.Pricing;
import com.property.exception.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class CustomPricingRepoImpl implements CustomPricingRepositry {
    @Autowired
    SessionFactory sf;

    @Override
    public void updatePricing(Pricing pricing) throws DaoException {
        try (Session session = sf.openSession()){
            Transaction t = session.beginTransaction();
            session.update(pricing);
            t.commit();
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    @Override
    public Optional<List<Listing>> getListingWithPriceRange(double minVal, double maxVal) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Listing> query = session.createQuery("select l from Listing l join fetch l.pricing p where p.price between :min and :max", Listing.class)
                    .setParameter("min", minVal).setParameter("max", maxVal);
            return Optional.ofNullable(query.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    @Override
    public Optional<List<Listing>> getListingWithTotalPriceRange(double minVal, double maxVal) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Listing> query = session.createQuery("select l from Listing l join fetch l.pricing p where (p.price+p.extra_charges) between :min and :max", Listing.class)
                    .setParameter("min", minVal).setParameter("max", maxVal);
            return Optional.ofNullable(query.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }
}
