package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public ModelAndView visualizar() {
		
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);

		Iterable<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
}
