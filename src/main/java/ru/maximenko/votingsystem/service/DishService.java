package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maximenko.votingsystem.repository.DishRepository;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;
}
