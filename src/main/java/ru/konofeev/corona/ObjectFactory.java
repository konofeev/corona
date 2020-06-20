package ru.konofeev.corona;

import lombok.SneakyThrows;

public class ObjectFactory {
    private static final ObjectFactory INSTANCE = new ObjectFactory();
    private Config config = new JavaConfig("ru.konofeev.corona");

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> classImplement = type;

        if (type.isInterface()) {
            classImplement = config.getImplClass(type);
        }

        return classImplement.getDeclaredConstructor().newInstance();
    }
}
