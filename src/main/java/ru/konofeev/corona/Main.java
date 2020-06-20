package ru.konofeev.corona;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Main
{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, FileNotFoundException, InvocationTargetException {
        new CoronaDesinfector().start(new Room());
    }
}
