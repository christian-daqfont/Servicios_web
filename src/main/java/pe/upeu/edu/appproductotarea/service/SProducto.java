package pe.upeu.edu.appproductotarea.service;

import java.util.List;

import pe.upeu.edu.appproductotarea.model.Producto;

public interface SProducto {
	Producto create(Producto pr);
	List<Producto> readAll();
	Producto read(Long id);
	void delete(Long id);
	Producto update(Producto pr);
}
