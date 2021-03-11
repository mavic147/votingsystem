package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.AbstractBaseEntity;

/**
 * Contains methods validating if entity:
 * 1) was found by id;
 * 2) was found by sth but id (email or other criteria)
 * 3) is new
 * It also checks id consistency
 */
public class EntityValidationUtil {

    private EntityValidationUtil() {}

    public static <T>T checkNotFoundById(T object, int id) {
        if (object == null) {
            checkNotFound("Not found entity with id = " + id);
        }
        return object;
    }

    public static <T>T checkNotFound(T object, String message) {
        if (object == null) {
            checkNotFound("Not found entity with " + message);
        }
        return object;
    }

    public static void checkNotFound(String message) {
        throw new EntityNotFoundException(message);
    }

    public static void checkNew(AbstractBaseEntity entity) {
        if (entity.getId() != null) {
            throw new IllegalArgumentException(entity + " must be new (id = null)!");
        }
    }

    public static void assureIdConsistent(AbstractBaseEntity entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }
}
