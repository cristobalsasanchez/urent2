package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Distancia;
import com.proyecto.urent.Model.Service.IDistanciaService;
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
public class DistanciaController {

    @Autowired
    private IDistanciaService distanciaService;

    @GetMapping("/distancia")
    public List<Distancia> index(){
        return distanciaService.findAll();
    }

    @GetMapping("/distancia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Distancia distancia = null;
        Map<String, Object> response = new HashMap<>();

        try{
            distancia = distanciaService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(distancia == null){
            response.put("mensaje", "La distancia ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Distancia>(distancia, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/distancia")
    public ResponseEntity<?> create(@Valid @RequestBody Distancia distancia, BindingResult result) {

        Distancia distancia1 = null;
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
            distancia1 = distanciaService.save(distancia);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La distancia ha sido creado con exito!");
        response.put("distancia", distancia1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/distancia/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Distancia distancia, BindingResult result, @PathVariable Integer id){

        Distancia distanciaActual = distanciaService.findById(id);

        Distancia distanciaUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(distanciaActual == null){
            response.put("mensaje", "La distancia ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            distanciaActual.setEstado(distancia.getEstado());
            distanciaActual.setIdInmueble(distancia.getIdInmueble());
            distanciaActual.setIdSede(distancia.getIdSede());
            distanciaActual.setKilometros(distancia.getKilometros());

            distanciaUpdate = distanciaService.save(distanciaActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar la distancia en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La distancia ha sido actualizado con exito!");
        response.put("distancia", distanciaUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/distancia/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            distanciaService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar la distancia en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La distancia fue eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
