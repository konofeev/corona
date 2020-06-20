package ru.konofeev.corona;

public class CoronaDesinfector
{
    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);
    
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
