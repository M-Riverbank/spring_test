package dsy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //作用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {
    String value();
}
