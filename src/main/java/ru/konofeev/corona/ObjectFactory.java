package ru.konofeev.corona;

import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;

public class ObjectFactory {
    private static final ObjectFactory INSTANCE = new ObjectFactory();
    private Config config;

    private ObjectFactory() {
        Map<Class, Class> interfaceToClassImpl = new HashMap<Class, Class>();
        interfaceToClassImpl.put(Policeman.class, AngryPoliceman.class);
        config = new JavaConfig("ru.konofeev.corona", interfaceToClassImpl);
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

        T typeImpl = classImplement.getDeclaredConstructor().newInstance();

        for (Field field: classImplement.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
        }

        return typeImpl;
    }
}
