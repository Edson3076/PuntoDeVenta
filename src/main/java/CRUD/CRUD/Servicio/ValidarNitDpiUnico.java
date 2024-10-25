package CRUD.CRUD.Servicio;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidarNitDpiUnicoImpl.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidarNitDpiUnico {
    String message() default "El DPI o NIT ya existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};    
}
