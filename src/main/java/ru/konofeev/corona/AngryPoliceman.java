package ru.konofeev.corona;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePoliceLeaveRoom() {
        System.out.println("Немедленно уйти, иначе всех постреляем!");
    }
}
