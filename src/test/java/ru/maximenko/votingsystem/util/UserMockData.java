package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Role;
import ru.maximenko.votingsystem.model.User;

import java.util.Collections;
import java.util.Date;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class UserMockData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = USER_ID + 1;

    public static final User Bob = new User(USER_ID + 2, "UserBob", "bob@mail.ru", "bob123",
            new Date(), Collections.singleton(Role.USER));
    public static final User Angelina = new User(USER_ID + 3, "UserAngelina", "angelina@gmail.com",
            "angelina555", new Date(), Collections.singleton(Role.USER));
    public static final User Steve = new User(USER_ID + 4, "AdminSteve", "steve@yahoo.com",
            "steve321", new Date(), Collections.singleton(Role.ADMIN));
    public static final User Carmen = new User(USER_ID + 5, "AdminCarmen", "carmen@yandex.ru",
            "carm567", new Date(), Collections.singleton(Role.ADMIN));

    public static User getNew() {
        return new User(null, "UserDrake", "drake@gmail.com", "drakkke777", new Date(), Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updUser = new User(Bob);
        updUser.setName("UserBobbie");
        updUser.setEmail("bobbie@mail.ru");
        updUser.setPassword("bobbie123");
        return updUser;
    }
}
