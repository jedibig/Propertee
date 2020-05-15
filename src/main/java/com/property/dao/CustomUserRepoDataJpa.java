package com.property.dao;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DuplicateEmailException;
import com.property.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CustomUserRepoDataJpa implements CustomUserRepository {

    final UserRepository userRepository;

    @Override
    public long insertUser(User user) throws DuplicateEmailException, DaoException {
        return userRepository.save(user).getId();
    }

    @Override
    public void updateUser(User user) throws DaoException {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) throws DaoException {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> verifyUserLogin(User user) throws DaoException {
        //TODO Not implemented
        return Optional.empty();
    }

    @Override
    public User getUserById(long id) throws DaoException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Optional<User> getUserByEmail(String email){
        return userRepository.findFirstByEmail(email);
    }
}
