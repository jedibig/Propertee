//package com.property.dao;
//
//import com.property.dto.User;
//import com.property.exception.DaoException;
//import com.property.exception.DuplicateEmailException;
//import com.property.exception.UserNotFoundException;
//import lombok.AllArgsConstructor;
//import java.util.logging.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import java.util.Optional;
//
//@AllArgsConstructor
//public class CustomUserRepoImpl implements CustomUserRepository {
//    static Logger logger = Logger.getLogger(CustomUserRepoImpl.class.getName());
//
//    final SessionFactory sf;
//
//    public long insertUser(User user) throws DuplicateEmailException, DaoException {
//        try (Session session = sf.openSession()){
//            if (session.get("id", user.getEmail()) != null)
//                throw new DuplicateEmailException();
//
//            Transaction t = session.beginTransaction();
//            session.persist(user);
//            long id = user.getId();
//            t.commit();
//
//            return id;
//        } catch (HibernateException e){
//            throw new DaoException(e);
//        }
//    }
//
//    public void updateUser(User user) throws DaoException {
//        try (Session session = sf.openSession()){
//
//            Query query= session.createQuery("select id from User where email = :email").setParameter("email",user.getEmail());
//            Long id = (Long) query.uniqueResult();
//            if (id == null)
//                throw new UserNotFoundException();
//
//            Transaction t = session.beginTransaction();
//            user.setId(id);
//            session.update(user);
//            t.commit();
//
//        } catch (HibernateException e){
//            throw new DaoException(e);
//        }
//    }
//
//    public void removeUser(User user) throws DaoException {
//        try (Session session = sf.openSession()){
//
//            Query query= session.createQuery("select id from User where email = :email").setParameter("email",user.getEmail());
//            Long id = (Long) query.uniqueResult();
//            if (id == null)
//                throw new UserNotFoundException();
//
//            Transaction t = session.beginTransaction();
//            session.delete(user);
//            t.commit();
//
//        } catch (HibernateException e){
//            throw (DaoException) new DaoException(e);
//        }
//    }
//
//    public Optional<User> verifyUserLogin(User user) throws DaoException, UserNotFoundException {
//        try (Session session = sf.openSession()){
//
//            return Optional.ofNullable(
//                    session.createQuery("select id, email, phonenumber from User where email = ?1 and password = ?2", User.class)
//                            .setParameter(1, user.getEmail())
//                            .setParameter(2, user.getPassword())
//                            .uniqueResult()
//            );
//
//        } catch (HibernateException e){
//            throw new DaoException(e);
//        }
//
//    }
//
//    public User getUserById(long id) throws DaoException {
//        return null;
//    }
//
//    @Override
//    public User getUserByEmail(String email) throws DaoException {
//        return null;
//    }
//}
