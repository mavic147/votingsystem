package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.AbstractBaseEntity;

/**
 * Contains methods validating if entity:
 * 1) was found by id;
 * 2) was found by sth but id (email or other criteria)
 * 3) is new
 * It also checks id consistency
 */
public class ValidationUtil {

    private ValidationUtil() {}

    public static <T>T checkNotFoundById(T object, int id) throws NotFoundException {
        checkNotFoundById(object != null, id);
        return object;
    }

    public static void checkNotFoundById(boolean found, int id) throws NotFoundException {
        checkNotFound(found, "id = " + id);
    }

    public static <T>T checkNotFound(T object, String message) throws NotFoundException {
        checkNotFound(object != null, message);
        return object;
    }

    public static void checkNotFound(boolean found, String message) throws NotFoundException {
        if (!found) {
            throw new NotFoundException("Not found entity with " + message);
        }
    }

    public static void checkNew(AbstractBaseEntity entity) {
        if (entity.getId() != null) {
            throw new IllegalArgumentException(entity + " must be new (id = null)!");
        }
    }

    public static void assureIdConsistent(AbstractBaseEntity entity, int id) {
//      conservative when you reply, but accept liberally (http://stackoverflow.com/a/32728226/548473)
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }
}
