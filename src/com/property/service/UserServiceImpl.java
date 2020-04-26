package com.property.service;

import com.property.dao.UserRepository;
import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DuplicateEmailException;
import com.property.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;

    @Override
    public void insertNewUser(User user) throws DuplicateEmailException, DaoException {
        userRepository.insertUser(user);
    }

    @Override
    public Optional<User> validateUser(User user) throws UserNotFoundException, DaoException {
        return userRepository.verifyUserLogin(user);
    }

}
