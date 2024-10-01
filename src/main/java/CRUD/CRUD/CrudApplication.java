package CRUD.CRUD;

import CRUD.CRUD.ENTIDAD.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import CRUD.CRUD.Repositorio.ClienteRepositorio;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
    @Autowired
    private ClienteRepositorio repositorio;
    @Override
    public void run(String... args) throws Exception {
        /*
        Estudiante estudiante1 = new Estudiante("232669066","edson", "lote 45-G", "edson@hotmail.com","notas","hoy","Activo");
        repositorio.save(estudiante1);
        
        Estudiante estudiante2 = new Estudiante("javier", "Subuyuj", "javier@hotmail.com");
        repositorio.save(estudiante2);
        */
    }

}
