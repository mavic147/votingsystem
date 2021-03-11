package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.User;
import ru.maximenko.votingsystem.repository.UserRepository;

import java.util.List;

import static ru.maximenko.votingsystem.util.ValidationUtil.checkNotFoundById;
import static ru.maximenko.votingsystem.util.ValidationUtil.checkNotFound;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void delete(int id) {
        checkNotFoundById(userRepository.deleteById(id), id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "Email mustn't be null!");
        return checkNotFound(userRepository.findByEmail(email), "email = " + email);
    }

    public User getById(int id) {
        return checkNotFoundById(userRepository.findById(id).orElse(null), id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(User user) {
        Assert.notNull(user, "user must not be null");
        if (getById(user.getId()) == null) {
            return null;
        }
        return checkNotFoundById(userRepository.save(user), user.getId());
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }
}
