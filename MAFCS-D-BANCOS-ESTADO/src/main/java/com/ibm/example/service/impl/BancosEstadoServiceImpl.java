package com.ibm.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.example.dao.BancosEstadosDao;
import com.ibm.example.model.Banco;
import com.ibm.example.model.BancoModel;
import com.ibm.example.service.BancosEstadoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BancosEstadoServiceImpl implements BancosEstadoService{

  @Autowired
  BancosEstadosDao dao;
  
  @Override
  public List<BancoModel> findBancos(String estado) {
    log.info("Searching by state {}", estado);
    
    List<Banco> bancos = dao.findByPropiedadesEstado(estado);
    
    List<BancoModel> response = new ArrayList<>();
    
    bancos.forEach(bank ->{
      BancoModel banco = new BancoModel();
      banco.setDireccion(bank.getPropiedades().getDireccion());
      banco.setEstado(bank.getPropiedades().getEstado());
      banco.setHoraApertura(bank.getPropiedades().getHora_apertura());
      banco.setHoraCierre(bank.getPropiedades().getHora_cierre());
      banco.setNombre(bank.getPropiedades().getNombre());
      banco.setTelefono(bank.getPropiedades().getTelefono());
      banco.setTipoSucursal(bank.getPropiedades().getTipo_sucursal());
      response.add(banco);
        
        
    });
    
    
    
    return response;
  }

}
