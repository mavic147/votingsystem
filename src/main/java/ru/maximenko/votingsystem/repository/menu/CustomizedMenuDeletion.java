package ru.maximenko.votingsystem.repository.menu;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface CustomizedMenuDeletion {

    @Transactional
    @Modifying
    int delete(int id);
}
