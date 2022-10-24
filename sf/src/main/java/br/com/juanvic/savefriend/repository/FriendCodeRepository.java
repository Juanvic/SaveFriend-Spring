package br.com.juanvic.savefriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.juanvic.savefriend.entity.FriendCode;

@Repository
public interface FriendCodeRepository extends JpaRepository<FriendCode, Long> {

	
	
	
}
