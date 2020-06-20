package ru.konofeev.corona;

public class PolicemanImpl implements Policeman {
    @Override
    public void makePoliceLeaveRoom() {
        System.out.println("Всем разойтись, будет проходить дизинфекция помещения!");
    }
}
