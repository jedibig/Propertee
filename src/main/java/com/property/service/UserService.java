package com.property.service;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DuplicateEmailException;
import com.property.exception.UserNotFoundException;

import java.util.Optional;

public interface UserService {

    void insertNewUser(User user) throws DuplicateEmailException, DaoException;
    Optional<User> validateUser(User user) throws UserNotFoundException, DaoException;
    void updateUser(User user) throws DaoException;
    long getUserIdFromEmail(String email);
}
