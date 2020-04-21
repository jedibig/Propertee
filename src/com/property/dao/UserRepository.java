package com.property.dao;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DtoException;

public interface UserRepository {
    /**
     * @param user
     * @return int generated id from db.
     */
    long insertUser(User user) throws DaoException;
    void updateUser(User user) throws DaoException;
    void removeUser(User user) throws DaoException;
    boolean verifyUserLogin(User user) throws DaoException, DtoException;
    User getUserById(long id) throws DaoException;
}
