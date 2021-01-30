package ec.pymeapps.micro.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Para correr en otro puerto como argumento de la VM
 * 
 * -Dserver.port=9001
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
