package org.example;

/**
 * Клас для демонстрації серіалізації об'єкта типу Product.
 */
class Product {
    @JsonElement
    @XmlElement
    private String title;

    @JsonElement(key = "price_usd")
    @XmlElement(key = "price")
    private double price;

    /**
     * Конструктор для ініціалізації полів об'єкта Product.
     * @param title назва продукту
     * @param price ціна продукту
     */
    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }
}