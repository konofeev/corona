package ru.konofeev.corona;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class ConsoleAnnouncer implements Announcer {
    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);

    public ConsoleAnnouncer() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, FileNotFoundException {
    }

    @Override
    public void annonce(String message)
    {
        System.out.println(message);
        recommendator.recommend();
    }
}
