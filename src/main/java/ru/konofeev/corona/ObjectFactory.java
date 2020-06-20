package ru.konofeev.corona;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ObjectFactory {
    private static final ObjectFactory INSTANCE = new ObjectFactory();
    private final Config config;

    private ObjectFactory() {
        Map<Class, Class> interfaceToClassImpl = new HashMap<>();
        interfaceToClassImpl.put(Policeman.class, AngryPoliceman.class);
        config = new JavaConfig("ru.konofeev.corona", interfaceToClassImpl);
    }

    public static ObjectFactory getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, FileNotFoundException {
        Class<? extends T> classImplement = type;

        if (type.isInterface()) {
            classImplement = config.getImplClass(type);
        }

        T typeImpl = classImplement.getDeclaredConstructor().newInstance();

        for (Field field : classImplement.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            String path = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("application.properties")).getPath();
            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            Map<String, String> propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
            if (annotation != null) {
                String value = annotation.value().isBlank() ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(typeImpl, value);
            }
        }

        return typeImpl;
    }
}
