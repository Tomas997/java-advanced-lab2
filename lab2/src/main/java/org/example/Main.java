package org.example;

import java.time.Duration;
import java.time.Instant;

/**
 * Основний клас для демонстрації роботи серіалізатора з анотаціями та рефлексією.
 */
public class Main {
    /**
     * Головний метод для запуску програми.
     * @param args аргументи командного рядка
     * @throws IllegalAccessException у випадку помилки доступу до полів об'єкта
     */
    public static void main(String[] args) throws IllegalAccessException {
        // Ініціалізація об'єктів
        Person person = new Person("John Doe", 30);
        Product product = new Product("Laptop", 1200.5);
        Vehicle vehicle = new Vehicle("Tesla Model 3", 2022);

        // Серіалізація з рефлексією
        System.out.println("\nJSON серіалізація з рефлексією:");
        System.out.println(Serializer.toJson(person));
        System.out.println(Serializer.toJson(product));

        System.out.println("\nXML серіалізація з рефлексією:");
        System.out.println(Serializer.toXml(person));
        System.out.println(Serializer.toXml(product));

        // Серіалізація без рефлексії
        System.out.println("\nСеріалізація без рефлексії для Vehicle:");
        System.out.println(vehicle.toJsonManual());
        System.out.println(vehicle.toXmlManual());

        // Замір часу
        Instant startReflection = Instant.now();
        for (int i = 0; i < 100000; i++) {
            Serializer.toJson(person);
        }
        Instant endReflection = Instant.now();

        Instant startManual = Instant.now();
        for (int i = 0; i < 100000; i++) {
            vehicle.toJsonManual();
        }
        Instant endManual = Instant.now();

        System.out.println("\nЧас серіалізації з рефлексією: "
                + Duration.between(startReflection, endReflection).toMillis() + " ms");
        System.out.println("Час серіалізації без рефлексії: "
                + Duration.between(startManual, endManual).toMillis() + " ms");
    }
}
