package ec.pymeapps.micro.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  Para arrancar en otro puerto (pobrar el balance de carga) otra instancia 
 *  poner en los argumentos de la VM el parametro
 *    
 *  -Dserver.port=9001
 * 
 * 
 * @author Editor
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class UdeMicroServiceProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdeMicroServiceProductosApplication.class, args);
	}

}
