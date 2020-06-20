package ru.konofeev.corona;

import java.util.Set;
import java.util.Map;
import org.reflections.Reflections;

public class JavaConfig implements Config {
    private Reflections scanner;
    private Map<Class, Class> interfaceToClassImpl;

    public JavaConfig(String packageToScan, Map<Class, Class> interfaceToClassImpl)
    {
        scanner = new Reflections(packageToScan);
        this.interfaceToClassImpl = interfaceToClassImpl;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> interfaceType) {
        return interfaceToClassImpl.computeIfAbsent(interfaceType, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(interfaceType);

            if (classes.size() != 1) {
                throw new RuntimeException("Найдено более одной реализации интерфейса " + interfaceType + ". Обновите конфигурацию");
            }

            return classes.iterator().next();
        });
    }
}
