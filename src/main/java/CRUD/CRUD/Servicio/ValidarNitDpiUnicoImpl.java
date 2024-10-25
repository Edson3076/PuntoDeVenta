package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Cliente;
import CRUD.CRUD.Repositorio.ClienteRepositorio;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarNitDpiUnicoImpl implements ConstraintValidator<ValidarNitDpiUnico, String> {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public void initialize(ValidarNitDpiUnico constraintAnnotation) {
    }

    @Override
    public boolean isValid(String existe, ConstraintValidatorContext context) {
        try {
            //busca si el nit o dpi ya existe en la base de datos    
            if (existe == null || existe.isEmpty()) {
                return true;
            }
            return !clienteRepositorio.findByNitDpi(existe).isPresent();

        } catch (Exception e) {
            return false;
        }

        /*
            if (existe == null || existe.isEmpty()) {
            return true;
            }
            Optional<Cliente> clienteExistente = clienteRepositorio.findByNitDpi(existe);
            return clienteExistente.isEmpty();
         */
        //return false;
    }
    
    public ValidarNitDpiUnicoImpl(){
    }
}
