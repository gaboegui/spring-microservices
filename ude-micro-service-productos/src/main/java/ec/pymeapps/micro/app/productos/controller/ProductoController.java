package ec.pymeapps.micro.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ec.pymeapps.micro.app.productos.models.entity.Producto;
import ec.pymeapps.micro.app.productos.models.service.ProductoService;


@RestController // hace que todos los metodos retornen por defecto objetos JSON
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return service.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto ver(@PathVariable Long id){
		return service.findById(id);
	}
	
}
