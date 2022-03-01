package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//	@GetMapping("/home")
//	public String home(Model model) {
//
//		Pedido pedido = new Pedido();
//		pedido.setNomeProduto("Redmi Note 10S");
//		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51vmFmPmwiL._AC_SL1000_.jpg");
//		pedido.setUrlProduto(
//				"https://www.amazon.com.br/Redmi-Note-Starlight-Purple-128GB/dp/B09DD8J1RS/ref=Oct_d_otopr_16243890011?pd_rd_i=B09DD8J1RS&pd_rd_r=84b1cba5-00ff-47c0-9bb6-5c608a72cfa5&pd_rd_w=ki0i6&pd_rd_wg=oIHX4&pf_rd_p=3fd9fd9d-d2d3-4466-a00f-948526a3aced&pf_rd_r=ATBCDK5XYTWE9MT31RMC&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
//		pedido.setDescricao("Celular Xiome");
//
//		List<Pedido> pedidos = Arrays.asList(pedido);
//		model.addAttribute("pedidos", pedidos);
//
//		return "home";
//	}

	@GetMapping
	public ModelAndView visualizar() {

		Iterable<Pedido> pedidos = pedidoRepository.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}

//	@GetMapping("/aguardando")
//	public ModelAndView aguardando() {
//
//		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
//		ModelAndView mv = new ModelAndView("home");
//		mv.addObject("pedidos", pedidos);
//		return mv;
//
//	}
	
	@GetMapping("/{status}")
	public ModelAndView porStatus(@PathVariable String status) {

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		mv.addObject("status", status);
		return mv;

	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		
		return "redirect:/home";
	}
}
