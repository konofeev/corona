package ru.konofeev.corona;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> interfaceType);
}
