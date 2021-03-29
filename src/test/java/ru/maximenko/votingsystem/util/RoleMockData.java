package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Role;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class RoleMockData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = USER_ID + 1;

    public static final Role user = new Role(USER_ID, "user");
    public static final Role admin = new Role(ADMIN_ID, "admin");
}
