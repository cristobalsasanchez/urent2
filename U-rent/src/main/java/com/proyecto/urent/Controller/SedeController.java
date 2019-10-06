package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Sede;
import com.proyecto.urent.Model.Service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class SedeController {
    @Autowired
    private ISedeService sedeService;

    @GetMapping("/sede")
    public List<Sede> index(){
        return sedeService.findAll();
    }

    @GetMapping("/sede/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Sede sede = null;
        Map<String, Object> response = new HashMap<>();

        try{
            sede = sedeService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(sede == null){
            response.put("mensaje", "La Sede ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Sede>(sede, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/sede")
    public ResponseEntity<?> create(@Valid @RequestBody Sede sede, BindingResult result) {

        Sede sede1 = null;
        Map<String , Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String , Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            sede1 = sedeService.save(sede);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La sede ha sido creado con exito!");
        response.put("sede", sede1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/sede/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Sede sede, BindingResult result, @PathVariable Integer id){

        Sede sedeActual = sedeService.findById(id);

        Sede sedeUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(sedeActual == null){
            response.put("mensaje", "La sede ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            sedeActual.setDireccion(sede.getDireccion());
            sedeActual.setNombre(sede.getNombre());
            sedeActual.setEstado(sede.getEstado());
            sedeActual.setIdUniversidad(sede.getIdUniversidad());

            sedeUpdate = sedeService.save(sedeActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar la sede en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La sede ha sido actualizado con exito!");
        response.put("sede", sedeUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/sede/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            sedeService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar la sede en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La sede fue eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
