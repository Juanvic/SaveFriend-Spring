package br.com.juanvic.savefriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.juanvic.savefriend.entity.FriendCode;
import br.com.juanvic.savefriend.service.FriendCodeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private FriendCodeService friendCodeService;
	
	@GetMapping({"/", "/friendcode"})
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/friendcode/listar.html");
		Iterable<FriendCode> codes = friendCodeService.buscarTodos();
		mv.addObject("codes", codes);
		return mv;
	}
	

}
