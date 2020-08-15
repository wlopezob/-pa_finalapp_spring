package com.example.appDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.appDemo.models.Token;
import com.example.appDemo.models.Venta;

@Repository
public interface IVentaRepository extends CrudRepository<Venta, Long> {

}
