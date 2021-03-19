package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface CustomizedMenuDeletion {

    @Transactional
    @Modifying
    int delete(int id, int restId);
}
