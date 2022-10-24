package br.com.juanvic.savefriend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FriendCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="plataform", nullable = false, length = 20)
	private String plataform;
	
	@Column(name="name", nullable = false, length = 50)
	private String name;
	
	@Column(name="code", nullable = false, length = 50)
	private String code;

	
	
	
	

}
