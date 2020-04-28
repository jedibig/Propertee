package com.property.dao;

import com.property.dto.Address;
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

public class CustomAddressRepositoryImpl implements CustomAddressRepository {
    @Autowired
    SessionFactory sf;

    @Override
    public void updateAddress(Address address) throws DaoException {
        try (Session session = sf.openSession()){
            Transaction t = session.beginTransaction();
            session.update(address);
            t.commit();
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    @Override
    public Optional<List<Long>> getListingByCity(String city) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Long> queryListingId = session.createQuery("select a.listing_id from Address a where a.city = :param", Long.class)
                    .setParameter("param", city);
            return Optional.ofNullable(queryListingId.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    @Override
    public Optional<List<Long>> getListingByZipcode(String zipcode) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Long> queryListingId = session.createQuery("select a.listing_id from Address a where a.zipcode = :param", Long.class)
                    .setParameter("param", zipcode);
            return Optional.ofNullable(queryListingId.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    @Override
    public Optional<List<Long>> getListingByState(String state) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Long> queryListingId = session.createQuery("select a.listing_id from Address a where a.state = :param", Long.class)
                    .setParameter("param", state);
            return Optional.ofNullable(queryListingId.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }
}
