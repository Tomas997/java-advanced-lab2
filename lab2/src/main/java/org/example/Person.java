package org.example;

/**
 * Клас для демонстрації серіалізації об'єкта типу Person.
 */
class Person {
    @JsonElement(key = "full_name")
    @XmlElement(key = "name")
    private String name;

    @JsonElement(key = "years_old")
    @XmlElement(key = "age")
    private int age;

    /**
     * Конструктор для ініціалізації полів об'єкта Person.
     * @param name ім'я особи
     * @param age вік особи
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}