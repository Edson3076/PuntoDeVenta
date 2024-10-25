package CRUD.CRUD.Servicio;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ValidadorNitDpiImpl implements ConstraintValidator<ValidarNitDpi, String> {

    //Mapa de departamentos y sus rangos validos de municipios
    private static final Map<String, Integer> departamentos = new HashMap<>();

    static {
        //  inicializacion de los departamentos con el maximo de municipios
        departamentos.put("01", 17);
        departamentos.put("03", 8);
        departamentos.put("03", 16);
        departamentos.put("04", 19);
        departamentos.put("05", 21);
        departamentos.put("06", 19);
        departamentos.put("07", 14);
        departamentos.put("08", 17);
        departamentos.put("09", 24);
        departamentos.put("10", 19);
        departamentos.put("11", 26);
        departamentos.put("12", 32);
        departamentos.put("13", 17);
        departamentos.put("14", 8);
        departamentos.put("15", 15);
        departamentos.put("16", 17);
        departamentos.put("17", 14);
        departamentos.put("18", 11);
        departamentos.put("19", 11);
        departamentos.put("20", 7);
        departamentos.put("21", 17);
        departamentos.put("22", 7);
    }

    @Override
    public void initialize(ValidarNitDpi constraintAnnotation) {
        //inicializacion si es necesario
    }

    @Override
    public boolean isValid(String nitDpi, ConstraintValidatorContext context) {
        if (nitDpi == null || nitDpi.isEmpty()) {
            return false;
        }
        try {
            // comprobar si es Nit o DPI
            if (nitDpi.matches("\\d{13}")) {
                return validarDpi(nitDpi); //validar Dpi
            } else if (nitDpi.matches("\\d{8}")) {
                return validarNit(nitDpi); //validar Nit
            }
        } catch (Exception e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Error al validar Nit o DPI").addConstraintViolation();
            return false;
        }
        return false; // No es Nit o DPI valido
    }

    //Si es DPI
    private boolean validarDpi(String dpi) {
        if (dpi.length() != 13) {
            return false;
        }
        try {
            //validar que el departamento si exista
            String codigoDepartamento = dpi.substring(9, 11);
            String codigoMunicipio = dpi.substring(11, 13);
            if (!departamentos.containsKey(codigoDepartamento)) {
                return false;
            }
            //validar que el codigo del municipio este en el rango permitido 
            int maxMunicipios = departamentos.get(codigoDepartamento);
            int numeroMunicipio = Integer.parseInt(codigoMunicipio);
            if (numeroMunicipio < 1 || numeroMunicipio > maxMunicipios) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;// DPI si es valido
    }

    //codigo de region ultimos 4 digitos        
    /*int codigoRegion = Integer.parseInt(dpi.substring(9,13));
        int departamento = codigoRegion /100;
        int municipio = codigoRegion%100;
        
        if (departamento<1 || departamento>22) {
            return false; //departamento invalido
        }
        if ((departamento==1 && municipio>17) || departamento==2 && municipio>8) {
            return false;
        }
     */
 /*
        //validar que el departamento si exista
        int codigoDepartamento = Integer.parseInt(dpi.substring(4, 6));
        int codigoMunicipio = Integer.parseInt(dpi.substring(6, 8));
        if (codigoDepartamento < 1 || codigoDepartamento > 22) {
            return false; //departamento invalido
        }
        if (!esMunicipioValido(codigoDepartamento, codigoMunicipio)) {
            return false;
        }
        return true;// DPI si es valido
    }

    private boolean esMunicipioValido(int codigoDepartamento, int codigoMunicipio) {
        // Validar según el número de municipios para cada departamento
        switch (codigoDepartamento) {
            case 1:  // Guatemala
                return codigoMunicipio >= 1 && codigoMunicipio <= 17;
            case 2:  // El Progreso
                return codigoMunicipio >= 1 && codigoMunicipio <= 8;
            case 3:  // Sacatepéquez
                return codigoMunicipio >= 1 && codigoMunicipio <= 16;
            case 4:  // Chimaltenango
                return codigoMunicipio >= 1 && codigoMunicipio <= 16;
            case 5:  // Escuintla
                return codigoMunicipio >= 1 && codigoMunicipio <= 13;
            case 6:  // Santa Rosa
                return codigoMunicipio >= 1 && codigoMunicipio <= 14;
            case 7:  // Sololá
                return codigoMunicipio >= 1 && codigoMunicipio <= 19;
            case 8:
                return codigoMunicipio >= 1 && codigoMunicipio <= 8;
            case 9:
                return codigoMunicipio >= 1 && codigoMunicipio <= 24;
            case 10:
                return codigoMunicipio >= 1 && codigoMunicipio <= 21;
            case 11:
                return codigoMunicipio >= 1 && codigoMunicipio <= 9;
            case 12:
                return codigoMunicipio >= 1 && codigoMunicipio <= 30;
            case 13:
                return codigoMunicipio >= 1 && codigoMunicipio <= 33;
            case 14:
                return codigoMunicipio >= 1 && codigoMunicipio <= 21;
            case 15:
                return codigoMunicipio >= 1 && codigoMunicipio <= 8;
            case 16:
                return codigoMunicipio >= 1 && codigoMunicipio <= 17;
            case 17:
                return codigoMunicipio >= 1 && codigoMunicipio <= 14;
            case 18:
                return codigoMunicipio >= 1 && codigoMunicipio <= 5;
            case 19:
                return codigoMunicipio >= 1 && codigoMunicipio <= 11;
            case 20:
                return codigoMunicipio >= 1 && codigoMunicipio <= 11;
            case 21:
                return codigoMunicipio >= 1 && codigoMunicipio <= 7;
            case 22: // Baja Verapaz
                return codigoMunicipio >= 1 && codigoMunicipio <= 17;
            // Incluir todos los casos para los 22 departamentos
            // ...
            default:
                return false;
        }
    }
     */
    //Si es Nit
    private boolean validarNit(String nit) {
        nit = nit.replace("-", "");
        //El nit debe tener al menos 8 caracteres y hasta 10
        if (nit.length() < 8 || nit.length() > 10) {
            return false; //formato invalido
        }
        //Extraer los numeros y el digito verificador
        String numerosNit = nit.substring(0, nit.length() - 1);
        char digitoVerificadorIngresado = nit.charAt(nit.length() - 1);

        //Validar que los primeros numeros sean numericos
        if (!numerosNit.matches("\\d+")) {
            return false;
        }

        //calculare el digito verificador
        char digitoVerificadorEsperado = caldularDigitoVerificador(numerosNit);
        return digitoVerificadorEsperado == digitoVerificadorIngresado;

        /*
        if (nit.length()!=8 || !nit.matches("\\d+")) {
            return false;
        }
        int[] pesos = {4,3,2,7,6,5,4,3};
        int suma=0;
        
        for (int i = 0; i < 7; i++) {
        suma+=Character.getNumericValue(nit.charAt(i))*pesos[i];
        }
        int verificadorEsperado = 11-(suma%11);
        if (verificadorEsperado==11) {
            verificadorEsperado=0;
        }else if (verificadorEsperado==10) {
            verificadorEsperado=1;
        }
        return Character.getNumericValue(nit.charAt(7))== verificadorEsperado;
         */
    }

    private char caldularDigitoVerificador(String numerosNit) {
        int suma = 0;
        int factor = 2;

        for (int i = numerosNit.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numerosNit.charAt(i));
            suma += digito * factor;
            factor++;
            if (factor > 9) {
                factor = 2;
            }
        }
        int residuo = suma % 11;
        if (residuo == 0) {
            return '0';
        } else if (residuo == 1) {
            return 'k';
        } else {
            return (char) ('0' + (11 - residuo));
        }

    }

}
