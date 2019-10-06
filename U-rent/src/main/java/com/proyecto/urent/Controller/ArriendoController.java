package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Arriendo;
import com.proyecto.urent.Model.Service.IArriendoService;
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
public class ArriendoController {
    @Autowired
    private IArriendoService arriendoService;

    @GetMapping("/arriendo")
    public List<Arriendo> index(){
        return arriendoService.findAll();
    }

    @GetMapping("/arriendo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Arriendo arriendo = null;
        Map<String, Object> response = new HashMap<>();

        try{
            arriendo = arriendoService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(arriendo == null){
            response.put("mensaje", "El arriendo ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Arriendo>(arriendo, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/arriendo")
    public ResponseEntity<?> create(@Valid @RequestBody Arriendo arriendo, BindingResult result) {

        Arriendo arriendo1 = null;
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
            arriendo1 = arriendoService.save(arriendo);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El arriendo ha sido creado con exito!");
        response.put("arriendo", arriendo1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/arriendo/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Arriendo arriendo, BindingResult result, @PathVariable Integer id){

        Arriendo arriendoActual = arriendoService.findById(id);

        Arriendo arriendoUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(arriendoActual == null){
            response.put("mensaje", "El arriendo ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            arriendoActual.setFechaInicio(arriendo.getFechaInicio());
            arriendoActual.setFechaTermino(arriendo.getFechaTermino());
            arriendoActual.setIdArrendador(arriendo.getIdArrendador());
            arriendoActual.setIdArrendatario(arriendo.getIdArrendatario());
            arriendoActual.setIdInmueble(arriendo.getIdInmueble());
            arriendoActual.setEstado(arriendo.getEstado());

            arriendoUpdate = arriendoService.save(arriendoActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar el arriendo en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El arriendo ha sido actualizado con exito!");
        response.put("arriendo", arriendoUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/arriendo/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            arriendoService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el arriendo en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El arriendo fue eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
