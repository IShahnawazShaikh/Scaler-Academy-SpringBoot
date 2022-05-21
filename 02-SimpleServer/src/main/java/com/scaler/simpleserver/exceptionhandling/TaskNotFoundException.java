package com.scaler.simpleserver.exceptionhandling;

public class TaskNotFoundException extends IllegalArgumentException {
    public TaskNotFoundException(int id) {
        super("Could not find task " + id);
    }
}