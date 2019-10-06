package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Arrendatario;
import com.proyecto.urent.Model.Service.IArrendatarioService;
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
public class ArrendatarioController {
    @Autowired
    private IArrendatarioService arrendatarioService;

    @GetMapping("/arrendatario")
    public List<Arrendatario> index(){
        return arrendatarioService.findAll();
    }

    @GetMapping("/arrendatario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Arrendatario arrendatario = null;
        Map<String, Object> response = new HashMap<>();

        try{
            arrendatario = arrendatarioService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(arrendatario == null){
            response.put("mensaje", "El arrendatario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Arrendatario>(arrendatario, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/arrendatario")
    public ResponseEntity<?> create(@Valid @RequestBody Arrendatario arrendatario, BindingResult result) {

        Arrendatario arrendatario1 = null;
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
            arrendatario1 = arrendatarioService.save(arrendatario);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El arrendatario ha sido creado con exito!");
        response.put("arrendatario", arrendatario1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/arrendatario/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Arrendatario arrendatario, BindingResult result, @PathVariable Integer id){

        Arrendatario arrendatarioActual = arrendatarioService.findById(id);

        Arrendatario arrendatarioUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(arrendatarioActual == null){
            response.put("mensaje", "El arrendatario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            arrendatarioActual.setRutArrendatario(arrendatario.getRutArrendatario());
            arrendatarioActual.setCorreo(arrendatario.getCorreo());
            arrendatarioActual.setCalificacion(arrendatario.getCalificacion());
            arrendatarioActual.setTelefono(arrendatario.getTelefono());
            arrendatarioActual.setNombre(arrendatario.getNombre());
            arrendatarioActual.setEstado(arrendatario.getEstado());

            arrendatarioUpdate = arrendatarioService.save(arrendatarioActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar el arrendatario en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El arrendatario ha sido actualizado con exito!");
        response.put("arrendatario", arrendatarioUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/arrendatario/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            arrendatarioService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el arrendatario en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El arrendatario fue eliminado con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
