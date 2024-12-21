package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Анотація для мапінгу полів у XML формат.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface XmlElement {
    /**
     * Ключ для мапінгу поля у XML. Якщо не вказано, використовується ім'я поля.
     * @return ключ для XML
     */
    String key() default "";
}