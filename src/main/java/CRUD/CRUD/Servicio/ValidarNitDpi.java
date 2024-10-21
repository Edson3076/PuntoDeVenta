package CRUD.CRUD.Servicio;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidadorNitDpiImpl.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidarNitDpi {
    String message() default "El DPI o Nit no es valido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
