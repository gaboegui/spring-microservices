package ec.pymeapps.micro.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.pymeapps.micro.app.productos.models.service.ProductoService;
import ec.pymeapps.micro.commons.app.models.entity.Producto;


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
	
	/**
	 * @RequestBody sirve para que se sepa que los valores de los campos vienen en el request 
	 * (tienen que coincidir los campos del JSON con los de la clase) 
	 * 
	 * 
	 * @param producto
	 * @return
	 */
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return service.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto,
			@PathVariable Long id) {
		
		Producto productoDb = service.findById(id);
		
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
		
		return service.save(productoDb);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
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
