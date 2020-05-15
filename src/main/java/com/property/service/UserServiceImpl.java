package com.property.service;

import com.property.dao.CustomUserRepository;
import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DuplicateEmailException;
import com.property.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    CustomUserRepository userRepository;

    @Override
    public void insertNewUser(User user) throws DuplicateEmailException, DaoException {
        userRepository.insertUser(user);
    }

    @Override
    public Optional<User> validateUser(User user) throws UserNotFoundException, DaoException {
        return userRepository.verifyUserLogin(user);
    }


    @Override
    public void updateUser(User user) throws DaoException {
        userRepository.updateUser(user);
    }

    @Override
    public long getUserIdFromEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow(UserNotFoundException::new).getId();
    }

}
