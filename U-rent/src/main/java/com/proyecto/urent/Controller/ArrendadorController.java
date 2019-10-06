package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Arrendador;
import com.proyecto.urent.Model.Service.IArrendadorService;
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
public class ArrendadorController {
    @Autowired
    private IArrendadorService arrendadorService;

    @GetMapping("/arrendador")
    public List<Arrendador> index(){
        return arrendadorService.findAll();
    }

    @GetMapping("/arrendador/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Arrendador arrendador = null;
        Map<String, Object> response = new HashMap<>();

        try{
            arrendador = arrendadorService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(arrendador == null){
            response.put("mensaje", "El arrendador ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Arrendador>(arrendador, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/arrendador")
    public ResponseEntity<?> create(@Valid @RequestBody Arrendador arrendador, BindingResult result) {

        Arrendador arrendador1 = null;
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
            arrendador1 = arrendadorService.save(arrendador);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El arrendador ha sido creado con exito!");
        response.put("arrendador", arrendador1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/arrendador/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Arrendador arrendador, BindingResult result, @PathVariable Integer id){

        Arrendador arrendadorActual = arrendadorService.findById(id);

        Arrendador arrendadorUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(arrendadorActual == null){
            response.put("mensaje", "El arrendador ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            arrendadorActual.setRutArrendador(arrendador.getRutArrendador());
            arrendadorActual.setCorreo(arrendadorActual.getCorreo());
            arrendadorActual.setCalificacion(arrendador.getCalificacion());
            arrendadorActual.setTelefono(arrendadorActual.getTelefono());
            arrendadorActual.setNombre(arrendador.getNombre());
            arrendadorActual.setEstado(arrendadorActual.getEstado());

            arrendadorActual = arrendadorService.save(arrendadorActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar el arrendador en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El arrendador ha sido actualizado con exito!");
        response.put("arrendador", arrendadorUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/arrendador/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            arrendadorService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el arrendador en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El arrendador fue eliminado con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
