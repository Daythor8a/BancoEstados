package com.ibm.example.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibm.example.model.Banco;
import com.ibm.example.repository.BancosRepository;

@Component
public class BancosEstadosDao {
  
  @Autowired
  BancosRepository repository;
  
  public List<Banco> findByPropiedadesEstado(String estado){
    return repository.findByPropiedadesEstado(estado);
  }

}
