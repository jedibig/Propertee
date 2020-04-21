package com.property.dao;

import com.property.dto.Address;
import com.property.dto.Listing;
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

public class AddressRepoImpl {
    @Autowired
    SessionFactory sf;

    public void updateAddress(Address address) throws DaoException {
        try (Session session = sf.openSession()){
            Transaction t = session.beginTransaction();
            session.update(address);
            t.commit();
        } catch (HibernateException e){
            throw (DaoException) new DaoException().initCause(e);
        }
    }

    public Optional<List<Listing>> getListingByCity(String city) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Listing> query = session.createQuery("select l from Listing l join fetch l.address where l.address.city = :city", Listing.class)
//            Query query = session.createQuery("from Listing l join l.address where l.address.city = :city")
                .setParameter("city", city);
            return Optional.ofNullable(query.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException().initCause(e);
        }
    }

    public Optional<List<Listing>> getListingByZipcode(String zipcode) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Listing> query = session.createQuery("select l from Listing l join fetch l.address where l.address.zipcode = :zipcode", Listing.class)
                    .setParameter(zipcode, zipcode);
            return Optional.ofNullable(query.getResultList());


        } catch (HibernateException e){
            throw (DaoException) new DaoException().initCause(e);
        }
    }

    public Optional<List<Listing>> getListingByState(String state) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Listing> query = session.createQuery("select l from Listing l join fetch l.address where l.address.state = :state", Listing.class)
                    .setParameter("state", state);
            return Optional.ofNullable(query.getResultList());
        } catch (HibernateException e){
            throw (DaoException) new DaoException().initCause(e);
        }
    }
}
