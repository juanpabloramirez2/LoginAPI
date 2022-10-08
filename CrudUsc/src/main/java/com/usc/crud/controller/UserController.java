package com.usc.crud.controller;

import com.usc.crud.model.Empleado;
import com.usc.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest_api/empleados")
public class UserController {

    @Autowired
    private  UserService service;


    @GetMapping("/consultar/{id}")
    public Empleado filtrar(@PathVariable Empleado empleado){

        return service.finByUser(empleado);

    }

    @GetMapping("/login/{user}&{pwd}")
    public boolean logged(@PathVariable String user, @PathVariable String pwd)
    {
        if(user.equals("Juan") && pwd.equals("123"))
            return true;
        else
            return false;
    }

    // create employee rest api
    @PostMapping("/guardar")
    public Empleado createEmployee(@RequestBody Empleado empleado) {
        return service.guardarUser(empleado);
    }

    @GetMapping("/consultarAll")

    public List<Empleado> consultarAll(){

        return service.buscarTdoso();

    }



    // update employee rest api



    // delete employee rest api
    @DeleteMapping("/Deleteuser/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
       String msj = service.eliminarUser(id);
        return ResponseEntity.ok(msj);
    }

}
