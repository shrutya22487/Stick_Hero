package com.example.stick_hero;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class testing_runner {
    public static void main(String[] args) {
        Result result= JUnitCore.runClasses(testing.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
