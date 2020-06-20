package ru.konofeev.corona;

public class ConsoleAnnouncer implements Announcer {
    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);

    @Override
    public void annonce(String message)
    {
        System.out.println(message);
        recommendator.recommend();
    }
}
