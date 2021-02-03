package ec.pymeapps.micro.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *  Para arrancar en otro puerto (pobrar el balance de carga) otra instancia 
 *  poner en los argumentos de la VM el parametro
 *    
 *  -Dserver.port=9001
 * 
 * 	con @EntityScan hago que busque las clases Entity en la libreria commons y las
 * 	incluye en el contexto de este servicio
 * 
 * 
 * @author Gabriel
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"ec.pymeapps.micro.commons.app.models.entity"})
public class UdeMicroServiceProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdeMicroServiceProductosApplication.class, args);
	}

}
