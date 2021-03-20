package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomizedMenuDeletion {

    @Transactional
    @Modifying
    int delete(int id, int restId);
}
