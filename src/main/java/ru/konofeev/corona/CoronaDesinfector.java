package ru.konofeev.corona;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class CoronaDesinfector
{
    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public CoronaDesinfector() throws InvocationTargetException, NoSuchMethodException, InstantiationException, FileNotFoundException, IllegalAccessException {
    }

    public void start(Room room)
    {
        announcer.annonce("Начинаем дизинфекцию, все вон!");
        policeman.makePoliceLeaveRoom();
        desinfect(room);
        announcer.annonce("Рискните зайти обратно");
    }

    private void desinfect(Room room)
    {
        System.out.println("Дезинфекция комнаты");
    }
}
