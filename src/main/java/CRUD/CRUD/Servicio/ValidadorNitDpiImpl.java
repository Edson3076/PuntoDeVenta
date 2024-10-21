package CRUD.CRUD.Servicio;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ValidadorNitDpiImpl implements ConstraintValidator<ValidarNitDpi, String>{
     
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
        // comprobar si es Nit o DPI
        if (nitDpi.matches("\\d{13}") ) {
            return validarDpi(nitDpi); //validar Dpi
        }else if (nitDpi.matches("\\d{8}")) {
            return validarNit(nitDpi); //validar Nit
        }
        return false; // No es Nit o DPI valido
    }
    
    //Si es DPI
    private boolean validarDpi (String dpi){
        if (dpi.length()!=13) {
            return false;       
        }
        //validar que el departamento si exista
        String codigoDepartamento = dpi.substring(9, 11);
        String codigoMunicipio = dpi.substring(11, 13);
        if (!departamentos.containsKey(codigoDepartamento)) {
            return false;
        }
        //validar que el codigo del municipio este en el rango permitido 
        int maxMunicipios = departamentos.get(codigoDepartamento);
        int numeroMunicipio = Integer.parseInt(codigoMunicipio);
        if (numeroMunicipio<1 || numeroMunicipio>maxMunicipios) {
            return false;
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
        
        return true;// DPI si es valido
    }
    
    //Si es Nit
    private boolean validarNit (String nit){
        nit=nit.replace("-","");
        //El nit debe tener al menos 8 caracteres y hasta 10
        if (nit.length()<8 || nit.length()>10) {
            return false; //formato invalido
        }
        //Extraer los numeros y el digito verificador
        String numerosNit = nit.substring(0, nit.length()-1);
        char digitoVerificadorIngresado = nit.charAt(nit.length()-1);
        
        //Validar que los primeros numeros sean numericos
        if (!numerosNit.matches("\\d+")) {
            return false;
        }
        
        //calculare el digito verificador
        char digitoVerificadorEsperado = caldularDigitoVerificador(numerosNit);
        return digitoVerificadorEsperado==digitoVerificadorIngresado;
        
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
    
    private char caldularDigitoVerificador(String numerosNit){
        int suma=0;
        int factor=2;
        
        for (int i = numerosNit.length()-1; i >=0; i--) {
            int digito = Character.getNumericValue(numerosNit.charAt(i));
            suma+=digito*factor;
            factor++;
            if (factor>9) {
                factor=2;
            }
        }
        int residuo = suma % 11;
        if (residuo==0) {
            return '0';
        }else if (residuo==1) {
            return 'k';
        }else{
                return (char)('0'+(11-residuo));
        }
        
    }
  
}