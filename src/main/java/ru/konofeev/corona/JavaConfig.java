package ru.konofeev.corona;

import java.util.Set;
import org.reflections.Reflections;

public class JavaConfig implements Config {
    private Reflections scanner;

    public JavaConfig(String packageToScan)
    {
        scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> interfaceType) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(interfaceType);

        if (classes.size() != 1) {
            throw new RuntimeException("Найдено более одной реализации интерфейса " + interfaceType);
        }

        return classes.iterator().next();
    }
}
