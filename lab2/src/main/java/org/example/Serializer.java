package org.example;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Клас для серіалізації об'єктів у JSON та XML формати з використанням рефлексії.
 */
class Serializer {
    /**
     * Серіалізує об'єкт у JSON формат, обробляючи анотації {@link JsonElement}.
     * @param obj об'єкт для серіалізації
     * @return JSON представлення об'єкта
     * @throws IllegalAccessException у випадку відсутності доступу до поля
     */
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, String> jsonElements = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonElement.class)) {
                field.setAccessible(true);
                String key = field.getAnnotation(JsonElement.class).key();
                jsonElements.put(key.isEmpty() ? field.getName() : key, field.get(obj).toString());
            }
        }
        return jsonElements.toString().replace("=", ": ");
    }

    /**
     * Серіалізує об'єкт у XML формат, обробляючи анотації {@link XmlElement}.
     * @param obj об'єкт для серіалізації
     * @return XML представлення об'єкта
     * @throws IllegalAccessException у випадку відсутності доступу до поля
     */
    public static String toXml(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder xml = new StringBuilder("<"+clazz.getSimpleName()+">\n");
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlElement.class)) {
                field.setAccessible(true);
                String key = field.getAnnotation(XmlElement.class).key();
                xml.append(String.format("  <%s>%s</%s>%n",
                        key.isEmpty() ? field.getName() : key, field.get(obj), key.isEmpty() ? field.getName() : key));
            }
        }
        xml.append("</"+clazz.getSimpleName()+">");
        return xml.toString();
    }
}