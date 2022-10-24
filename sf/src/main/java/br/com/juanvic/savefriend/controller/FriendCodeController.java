package br.com.juanvic.savefriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.juanvic.savefriend.entity.FriendCode;
import br.com.juanvic.savefriend.service.FriendCodeService;

@Controller
@RequestMapping("/friendcode")
public class FriendCodeController {
	
	@Autowired
	private FriendCodeService friendCodeService;

	@GetMapping("/adicionar")
	public ModelAndView telaAdicionar () {
		ModelAndView mv = new ModelAndView("friendcode/adicionar.html");
		return mv;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView adicionar (FriendCode friendCode, RedirectAttributes redirectAtributes) {
		System.out.println(friendCode);
		friendCodeService.salvarFC(friendCode);
		ModelAndView mv = new ModelAndView("redirect:/");
		redirectAtributes.addFlashAttribute("mensagemSucesso", "Código salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView telaEditar(@PathVariable Long id) {
		FriendCode friendCodeBanco = friendCodeService.buscarporId(id);
		ModelAndView mv = new ModelAndView("/friendcode/editar.html");
		mv.addObject("friendCode", friendCodeBanco);
		return mv;
	}
	
	@PutMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id, FriendCode friendCode) {
		friendCodeService.alterarFC(id, friendCode);
		ModelAndView mv = new ModelAndView("redirect:/friendcode");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView telaExcluir(@PathVariable Long id) {
		FriendCode friendCode = friendCodeService.buscarporId(id);
		ModelAndView mv = new ModelAndView("/friendcode/excluir.html");
		mv.addObject("friendCode", friendCode);
		return mv;
	}
	
	@DeleteMapping("/excluir/{id}")
	public ModelAndView deletar (@PathVariable Long id, RedirectAttributes redirectAttributes) {
		friendCodeService.deletarFC(id);
		ModelAndView mv = new ModelAndView("redirect:/friendcode");
		redirectAttributes.addFlashAttribute("mensagemSucesso", "Friendcode excluido com sucesso!");
		return mv;
	}
	
	
}
