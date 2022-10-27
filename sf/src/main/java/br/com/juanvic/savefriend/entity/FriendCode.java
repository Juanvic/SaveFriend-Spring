package br.com.juanvic.savefriend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class FriendCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="plataform", nullable = false, length = 20)
	@NotBlank(message = "Informe a plataforma")
	private String plataform;
	
	@NotBlank(message = "Informe o nome")
	@Column(name="name", nullable = false, length = 50)
	private String name;
	
	@NotBlank(message = "Informe o código")
	@Column(name="code", nullable = false, length = 50)
	private String code;

	
	
	
	

}
