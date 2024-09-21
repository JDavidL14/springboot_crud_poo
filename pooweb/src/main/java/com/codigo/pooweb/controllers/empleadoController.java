package com.codigo.pooweb.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codigo.pooweb.model.empleado;
import com.codigo.pooweb.services.empleadoService;

@RestController
public class empleadoController {
    private final empleadoService empleadoService;

    public empleadoController(empleadoService empleadoService){
        this.empleadoService=empleadoService;
    }
    @GetMapping("/empleado")
    public List<empleado> getAllempleados(){
        return empleadoService.getAllempleados();
    }
    @PostMapping("/empleado")
    public long createempleado(@RequestBody empleado newEmpleado){
        return empleadoService.createempleado(newEmpleado);
    }
    
}
