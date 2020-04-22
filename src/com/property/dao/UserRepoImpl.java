package com.property.dao;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.exception.DuplicateUsernameException;
import com.property.exception.UserNotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepository {
    Logger logger = Logger.getLogger(UserRepoImpl.class);

    @Autowired
    SessionFactory sf;

    public long insertUser(User user) throws DaoException {
        try (Session session = sf.openSession()){
            if (session.get("id", user.getEmail()) != null)
                throw new DuplicateUsernameException();

            Transaction t = session.beginTransaction();
            session.persist(user);
            long id = user.getId();
            logger.debug("inserted user with id " + id);
            t.commit();

            return id;
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    public void updateUser(User user) throws DaoException {
        try (Session session = sf.openSession()){

            Query query= session.createQuery("select id from User where email = :email").setParameter("email",user.getEmail());
            Long id = (Long) query.uniqueResult();
            if (id == null)
                throw new UserNotFoundException();

            Transaction t = session.beginTransaction();
            user.setId(id);
            session.update(user);
            t.commit();

        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    public void removeUser(User user) throws DaoException {
        try (Session session = sf.openSession()){

            Query query= session.createQuery("select id from User where email = :email").setParameter("email",user.getEmail());
            Long id = (Long) query.uniqueResult();
            if (id == null)
                throw new UserNotFoundException();

            Transaction t = session.beginTransaction();
            session.delete(user);
            t.commit();

        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    public boolean verifyUserLogin(User user) throws DaoException, DtoException {
        try (Session session = sf.openSession()){

            session.get(User.class, user.getEmail());
            Query<User> query= session.createQuery("select id, email, phonenumber from User where email = :email and password = :password", User.class);
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            if (session.get("id", user.getEmail()) == null)
                throw new UserNotFoundException();

            Transaction t = session.beginTransaction();
            session.delete(user);
            t.commit();

            return true;
        } catch (HibernateException e){
            throw (DaoException) new DaoException(e);
        }
    }

    public User getUserById(long id) throws DaoException {
        return null;
    }
}
