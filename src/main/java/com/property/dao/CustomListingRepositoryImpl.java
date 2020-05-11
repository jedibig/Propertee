package com.property.dao;

import com.property.dto.Listing;
import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.ListingNotFoundException;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class CustomListingRepositoryImpl implements CustomListingRepository {
    Logger logger = Logger.getLogger(CustomListingRepositoryImpl.class.getName());

    @Autowired SessionFactory sf;

    @Override
    public long insertNewListing(Listing listing) throws DaoException {
        try (Session session = sf.openSession()){

            logger.info("Attempting to add new listing to db.");
            User db_user = session.createQuery("from User where email = ?1", User.class).setParameter(1, listing.getUser().getEmail()).uniqueResult();
            if (db_user != null){
                logger.info("Updating user");
//                db_user.setPhonenumber(listing.getUser().getPhonenumber());
//                db_user.getListing().addAll(listing.getUser().getListing());
//                listing.setUser(db_user);
            }
            Transaction t = session.beginTransaction();
            logger.info("going to persist");

            session.persist(listing);
            logger.info("persisted");

            t.commit();
            logger.info("inserted listing with id " + listing.getListing_id());

            return listing.getListing_id();
        } catch (HibernateException e){
            logger.severe("Got error " + e.getMessage());
            throw new DaoException(e);
        }
    }

    @Override
    public void removeListingById(long listing_id) throws DaoException {
        try (Session session = sf.openSession()){
            Transaction t = session.beginTransaction();
            Listing listing = session.get(Listing.class, listing_id);
            if(listing == null)
                throw new ListingNotFoundException();
            session.delete(listing);
            t.commit();
        } catch (HibernateException e){
            throw new DaoException(e);
        }
    }

    @Override
    public void updateListing(Listing listing) throws DaoException {
        try (Session session = sf.openSession()){
            Transaction t = session.beginTransaction();
//            Query query = session.createQuery("update from Listing where listing_id = :listing_id").setParameter("listing_id", listing.getListing_id());
//            int rows = query.executeUpdate();
            session.update(listing);
            t.commit();
        } catch (HibernateException e){
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Listing> getListingById(long listing_id) throws DaoException {
        try (Session session = sf.openSession()){
            return Optional.ofNullable(session.get(Listing.class, listing_id));
        } catch (HibernateException e){
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<List<Listing>> getUserListings(String email) throws DaoException {
        try (Session session = sf.openSession()){
            //TODO query for getUserListings.
            Query<Listing> query = session.createQuery("select l from Listing l join l.user u where u.email = :email", Listing.class);
            query.setParameter("email", email);
            return Optional.ofNullable(query.getResultList());
        } catch (HibernateException e){
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<List<Listing>> getListingByIds(List<Long> ids) throws DaoException {
        try (Session session = sf.openSession()){
            List<Listing> listings = session.byMultipleIds(Listing.class).withBatchSize(10).multiLoad(ids);
            return Optional.ofNullable(listings);
        } catch (HibernateException e){
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<List<Listing>> getUserListings(long id) throws DaoException {
        try (Session session = sf.openSession()){
            Query<Listing> query = session.createQuery("select l from Listing l join l.user u where u.id = :id", Listing.class);
            query.setParameter("id", id);
            return Optional.ofNullable(query.getResultList());
        } catch (HibernateException e){
            throw new DaoException(e);
        }
    }
}
