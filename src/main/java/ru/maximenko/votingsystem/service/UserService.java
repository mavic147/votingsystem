package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.User;
import ru.maximenko.votingsystem.repository.user.UserRepository;

import java.util.List;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean delete(int id) {
        return checkNotFoundById(userRepository.deleteById(id), id) != 0;
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "Email mustn't be null!");
        return checkNotFound(userRepository.findByEmail(email), "email = " + email);
    }

    public User get(int id) {
        return checkNotFoundById(userRepository.findById(id).orElse(null), id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(User user) {
        Assert.notNull(user, "User must not be null");
        if (!user.isNew() && get(user.getId()) == null) {
            return null;
        }
        return userRepository.save(user);
    }

    public User create(User user) {
        Assert.notNull(user, "User must not be null");
        return userRepository.save(user);
    }
}
