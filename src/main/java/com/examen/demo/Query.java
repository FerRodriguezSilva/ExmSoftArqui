package com.examen.demo;

public interface Query<I, O> {
    O execute(I input);
}
