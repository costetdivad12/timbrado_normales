package iebem.edu.mx.timbre_normales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iebem.edu.mx.timbre_normales.configuration.WS10Client;
import iebem.edu.mx.timbre_normales.configuration.Ws10NormalesConfig;
import iebem.edu.mx.timbre_normales.wsprod.AutenticacionType;
import iebem.edu.mx.timbre_normales.wsprod.ConsultaModalidadRequest;
import iebem.edu.mx.timbre_normales.wsprod.ConsultaModalidadResponse;

@CrossOrigin
@RestController
@RequestMapping("/xml")
public class XmlController {
    
    @Autowired private WS10Client service;

    /**
     * 
     */
    @GetMapping("/ConsultarModalidad")
    public ConsultaModalidadResponse getConsultaModalidad (){
       
    ConsultaModalidadResponse respuesta=service.ConsultaModalidad(); 
    return respuesta;
}
}
