package ec.pymeapps.micro.app.productos.repository;

import org.springframework.data.repository.CrudRepository;

import ec.pymeapps.micro.commons.app.models.entity.Producto;

// al extender de CrudRepository la anotacion @Component ya esta implicita
public interface ProductoRepository extends  CrudRepository<Producto, Long>  {

}
