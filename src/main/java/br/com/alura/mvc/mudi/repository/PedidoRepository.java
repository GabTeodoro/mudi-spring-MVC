package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	
	List<Pedido> findByStatus(StatusPedido status);

}
