package ec.pymeapps.micro.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ec.pymeapps.micro.app.productos.models.entity.Producto;
import ec.pymeapps.micro.app.productos.models.service.ProductoService;


@RestController // hace que todos los metodos retornen por defecto objetos JSON
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@Autowired
	private Environment environment;
	
	//otra forma de obtener un valor del application.properties
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return service.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto ver(@PathVariable Long id) throws Exception{
		
		Producto prod = service.findById(id);
		//añado el puerto solo para verificar que este funcioanando el balanceo de carga
		//prod.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		prod.setPort(port);
		
		
		// Test de Timeout Hystrix y tambien sirve para Zuul
		//Thread.sleep(2000L);
		
		/*
		// Test de hystrix ejecucion de fallbackmethod
		boolean ok=false;
		if (ok == false) {
			throw new Exception("No se pudo cargar el producto");
		}
		*/
		
		return prod;
	}
	
}
