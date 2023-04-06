package com.example.springcalculator.component;

import org.springframework.stereotype.Component;

@Component
public interface ICalculator {

    int sum(int x, int y);
    int minus(int x, int y);
    void init();
}
