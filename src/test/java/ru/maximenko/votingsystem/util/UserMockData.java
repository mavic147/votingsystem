package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Role;
import ru.maximenko.votingsystem.model.User;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;
import static ru.maximenko.votingsystem.util.RoleMockData.*;

public class UserMockData {

    public static final int USER1_ID = ADMIN_ID + 1;
    public static final int USER2_ID = USER1_ID + 1;
    public static final int USER3_ID = USER2_ID + 1;
    public static final int USER4_ID = USER3_ID + 1;
    public static final int NOT_FOUND = START_SEQ + 1553;

    public static final String USER_EMAIL = "bob@mail.ru";
    public static final String CORRUPTED_EMAIL = "bobbr@mail.ru";

    public static final User Bob = new User(USER1_ID, "UserBob", "bob@mail.ru", "bob123",
            new Date(), Collections.singleton(user));
    public static final User Angelina = new User(USER2_ID, "UserAngelina", "angelina@gmail.com",
            "angelina555", new Date(), Collections.singleton(user));
    public static final User Steve = new User(USER3_ID, "AdminSteve", "steve@yahoo.com",
            "steve321", new Date(), Collections.singleton(admin));
    public static final User Carmen = new User(USER4_ID, "AdminCarmen", "carmen@yandex.ru",
            "carm567", new Date(), Collections.singleton(admin));

    public static List<User> allUsers = List.of(Bob, Angelina, Steve, Carmen);

    public static User getNew() {
        return new User(null, "UserDrake", "drake@gmail.com", "drakkke777", new Date(), Collections.singleton(user));
    }

    public static User getUpdated() {
        User updUser = new User(Bob);
        updUser.setName("UserBobbie");
        updUser.setEmail("bobbie@mail.ru");
        updUser.setPassword("bobbie123");
        return updUser;
    }
}
