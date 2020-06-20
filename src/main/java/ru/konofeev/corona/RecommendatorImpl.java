package ru.konofeev.corona;

public class RecommendatorImpl implements Recommendator {
    @InjectProperty
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("Защититесь от COVID-2019 с помощью напитка \"" + alcohol + "\"");
    }
}
