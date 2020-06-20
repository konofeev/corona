package ru.konofeev.corona;

public class ConsoleAnnouncer implements Announcer {
    @Override
    public void annonce(String message)
    {
        System.out.println(message);
    }
}
