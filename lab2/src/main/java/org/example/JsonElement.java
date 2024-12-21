package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Анотація для мапінгу полів у JSON формат.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonElement {
    /**
     * Ключ для мапінгу поля у JSON. Якщо не вказано, використовується ім'я поля.
     * @return ключ для JSON
     */
    String key() default "";
}