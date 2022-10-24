package br.com.juanvic.savefriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.juanvic.savefriend.entity.FriendCode;
import br.com.juanvic.savefriend.repository.FriendCodeRepository;

@Service
public class FriendCodeService {

	@Autowired
	private FriendCodeRepository friendCodeRepository;

	public FriendCodeService(FriendCodeRepository friendCodeRepository) {
		super();
		this.friendCodeRepository = friendCodeRepository;
	}
	

	public FriendCode salvarFC(FriendCode friendCode) {
		return friendCodeRepository.save(friendCode);
	}

	public FriendCode buscarporId(Long id) {
		return friendCodeRepository.findById(id).get();
	}
	
	public ModelAndView listaCodigos() {
		ModelAndView mv = new ModelAndView("/friendcode/listar.html");
		Iterable<FriendCode> codes = friendCodeRepository.findAll();
		mv.addObject("codes", codes);
		return mv;
	}
	
	public void excluirFC (Long id) {
		friendCodeRepository.deleteById(id); 
	}


	public List<FriendCode> buscarTodos() {
		return friendCodeRepository.findAll();
	}


	public FriendCode alterarFC(Long id, FriendCode friendCode) {
		FriendCode friendCodeBanco = friendCodeRepository.findById(id).get();
		friendCodeBanco.setPlataform(friendCode.getPlataform());
		friendCodeBanco.setName(friendCode.getName());
		friendCodeBanco.setCode(friendCode.getCode());
		return friendCodeRepository.save(friendCodeBanco);
	}


	public void deletarFC(Long id) {
		friendCodeRepository.deleteById(id);
	}

}
