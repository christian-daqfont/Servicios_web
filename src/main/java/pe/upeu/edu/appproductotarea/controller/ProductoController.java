package pe.upeu.edu.appproductotarea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.upeu.edu.appproductotarea.model.Producto;
import pe.upeu.edu.appproductotarea.service.ProductoService;

@RestController
@RequestMapping("/api")

public class ProductoController {

	@Autowired
	private ProductoService productoservice;
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> save(@RequestBody Producto prod){
		try {
			Producto pr = productoservice.create(new Producto(prod.getNombre(), prod.getPrecio(), prod.getStock()));
			return new ResponseEntity<>(pr, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getProductos(){
		try {
			List<Producto> list = new ArrayList<>();
			list = productoservice.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getUser(@PathVariable("id") long id){
		Producto producto = productoservice.read(id);
			if(producto.getIdproducto()>0) {
				return new ResponseEntity<>(producto, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("producto/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		try {
			productoservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("producto/update/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto prod, @PathVariable("id") long id){
		try {
			Producto ul = productoservice.read(id);
			if (ul.getIdproducto()>0) {
				ul.setNombre(prod.getNombre());
				ul.setPrecio(prod.getPrecio());
				ul.setStock(prod.getStock());
				return new ResponseEntity<>(productoservice.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
