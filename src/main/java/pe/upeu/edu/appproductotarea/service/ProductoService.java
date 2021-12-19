package pe.upeu.edu.appproductotarea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.upeu.edu.appproductotarea.model.Producto;
import pe.upeu.edu.appproductotarea.repository.ProductoRepository;

@Service
public class ProductoService implements SProducto{

	@Autowired
	private ProductoRepository productorepository;
	
	@Override
	public Producto create(Producto pr) {
		// TODO Auto-generated method stub
		return productorepository.save(pr);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productorepository.findAll();
	}

	@Override
	public Producto read(Long id) {
		// TODO Auto-generated method stub
		return productorepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productorepository.deleteById(id);
	}

	@Override
	public Producto update(Producto pr) {
		// TODO Auto-generated method stub
		return productorepository.save(pr);
	}

}
