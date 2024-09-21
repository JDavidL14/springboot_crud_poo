package com.codigo.pooweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.pooweb.model.empleado;
import com.codigo.pooweb.repositories.empleadoRepository;

@Service
public class empleadoService {
    private final empleadoRepository repository;

    public empleadoService(empleadoRepository repository){
        this.repository=repository;
    }
    public List<empleado> getAllempleados(){
        return repository.getAllempleados();
    }
    public long createempleado(empleado newEmpleado) {
        return repository.createempleado(newEmpleado);
    }
}
