package com.ibm.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.example.model.BancoModel;
import com.ibm.example.service.BancosEstadoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BancosEstadoController {
  
  @Autowired
  BancosEstadoService service;
  
  @GetMapping("${controller.uri}")
  public ResponseEntity<List<BancoModel>> getBancos(@PathVariable String state){
    
    log.info("controller receiving value: {}", state);
    List<BancoModel> bancos = service.findBancos(state);
    
    log.info("creturning response: {}", bancos);
    return new ResponseEntity<>(bancos, HttpStatus.OK);
    
    
  }

}
