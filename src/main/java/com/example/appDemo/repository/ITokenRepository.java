package com.example.appDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.appDemo.models.Token;

@Repository
public interface ITokenRepository extends CrudRepository<Token, Long> {

	Token findByPublico(String publico);
}
