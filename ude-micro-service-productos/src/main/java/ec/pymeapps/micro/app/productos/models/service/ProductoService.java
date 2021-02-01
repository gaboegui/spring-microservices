package ec.pymeapps.micro.app.productos.models.service;

import java.util.List;

import ec.pymeapps.micro.commons.app.models.entity.Producto;

public interface ProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);

}
