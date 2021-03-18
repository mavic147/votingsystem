package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.User;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = USER_ID + 1;

//    public static final User Bob = new User(USER_ID + 2, "UserBob", "bob@mail.ru", "bob123");
//    public static final User Angelina = new User();
//    public static final User Steve = new User();
//    public static final User Carmen = new User();
}
