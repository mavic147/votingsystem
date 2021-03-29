package ru.maximenko.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import ru.maximenko.votingsystem.model.User;
import ru.maximenko.votingsystem.util.EntityNotFoundException;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.maximenko.votingsystem.util.UserMockData.*;
import static ru.maximenko.votingsystem.util.RoleMockData.*;

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    protected UserService userService;

    @Test
    public void getOne() {
        User actual = userService.get(USER1_ID);
        assertThat(actual).usingRecursiveComparison().ignoringFields("registrationDate").isEqualTo(Bob);
    }

    @Test
    public void getByEmail() {
        User actual = userService.getByEmail(USER_EMAIL);
        assertThat(actual).usingRecursiveComparison().ignoringFields("registrationDate").isEqualTo(Bob);
    }

    @Test
    public void getByCorruptedEmail() {
        assertThrows(EntityNotFoundException.class, () -> userService.getByEmail(CORRUPTED_EMAIL));
    }

    @Test
    public void getNotExisting() {
        assertThrows(EntityNotFoundException.class, () -> userService.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        List<User> actualUsers = userService.getAll();
        assertThat(actualUsers).usingRecursiveComparison().ignoringFields("registrationDate").isEqualTo(allUsers);
    }

    @Test
    public void create() {
        User actualUser = userService.create(getNew());
        User expectedUser = getNew();
        int newId = actualUser.getId();
        expectedUser.setId(newId);
        assertThat(actualUser).usingRecursiveComparison().ignoringFields("registrationDate").isEqualTo(expectedUser);
        assertThat(userService.get(newId)).usingRecursiveComparison().ignoringFields("registrationDate").isEqualTo(expectedUser);
    }

    @Test
    public void createDuplicateEmail() {
        assertThrows(DataAccessException.class, () -> userService.create(new User(null, "UserMike",
                "bob@mail.ru", "somePass", new Date(), Collections.singleton(user))));
    }

    @Test
    public void update() {
        userService.update(getUpdated());
        assertThat(userService.get(USER1_ID)).usingRecursiveComparison().ignoringFields("registrationDate").isEqualTo(getUpdated());
    }

    @Test
    public void delete() {
        userService.delete(USER3_ID);
        assertThrows(EntityNotFoundException.class, () -> userService.get(USER3_ID));
    }

    @Test
    public void deleteNotFound() {
        userService.delete(USER3_ID);
        assertThrows(EntityNotFoundException.class, () -> userService.delete(USER3_ID));
        assertThrows(EntityNotFoundException.class, () -> userService.get(NOT_FOUND));
    }
}