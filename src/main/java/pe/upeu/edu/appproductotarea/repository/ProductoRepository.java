package pe.upeu.edu.appproductotarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.upeu.edu.appproductotarea.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
