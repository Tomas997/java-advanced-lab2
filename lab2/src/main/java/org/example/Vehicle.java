package org.example;

/**
 * Клас для демонстрації серіалізації об'єкта типу Vehicle без використання рефлексії.
 */
class Vehicle {
    private String model;
    private int year;

    /**
     * Конструктор для ініціалізації полів об'єкта Vehicle.
     * @param model модель транспортного засобу
     * @param year рік випуску
     */
    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    /**
     * Ручна серіалізація об'єкта у JSON формат.
     * @return JSON представлення об'єкта
     */
    public String toJsonManual() {
        return String.format("{\"model\": \"%s\", \"year\": %d}", model, year);
    }

    /**
     * Ручна серіалізація об'єкта у XML формат.
     * @return XML представлення об'єкта
     */
    public String toXmlManual() {
        return String.format("<Vehicle>\n  <model>%s</model>\n  <year>%d</year>\n</Vehicle>", model, year);
    }
}