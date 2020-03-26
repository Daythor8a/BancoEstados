package com.ibm.example.service;

import java.util.List;
import com.ibm.example.model.BancoModel;

public interface BancosEstadoService {
  
  List<BancoModel> findBancos(String estado);

}
