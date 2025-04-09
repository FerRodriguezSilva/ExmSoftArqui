package com.examen.demo;

public interface Command <I, O> {
    O execute(I input);
}

