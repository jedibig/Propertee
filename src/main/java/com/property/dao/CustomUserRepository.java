package com.property.dao;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DuplicateEmailException;

import java.util.Optional;

public interface CustomUserRepository {
    /**
     * @param user
     * @return int generated id from db.
     */
    long insertUser(User user) throws DuplicateEmailException, DaoException;
    void updateUser(User user) throws DaoException;
    void removeUser(User user) throws DaoException;
    Optional<User> verifyUserLogin(User user) throws DaoException;
    User getUserById(long id) throws DaoException;
    Optional<User> getUserByEmail(String email) throws DaoException;

}
