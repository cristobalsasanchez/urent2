package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Propiedad;
import com.proyecto.urent.Model.Service.IPropiedadService;
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
public class PropiedadController {
    @Autowired
    private IPropiedadService propiedadService;

    @GetMapping("/propiedad")
    public List<Propiedad> index(){
        return propiedadService.findAll();
    }

    @GetMapping("/propiedad/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Propiedad propiedad = null;
        Map<String, Object> response = new HashMap<>();

        try{
            propiedad = propiedadService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(propiedad == null){
            response.put("mensaje", "La Propiedad ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Propiedad>(propiedad, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/propiedad")
    public ResponseEntity<?> create(@Valid @RequestBody Propiedad propiedad, BindingResult result) {

        Propiedad propiedad1 = null;
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
            propiedad1 = propiedadService.save(propiedad);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La propiedad ha sido creado con exito!");
        response.put("propiedad", propiedad1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/propiedad/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Propiedad propiedad, BindingResult result, @PathVariable Integer id){

        Propiedad propiedadActual = propiedadService.findById(id);

        Propiedad propiedadUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(propiedadActual == null){
            response.put("mensaje", "La propiedad ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            propiedadActual.setFechaInicio(propiedad.getFechaInicio());
            propiedadActual.setFechaTermino(propiedad.getFechaTermino());
            propiedadActual.setEstado(propiedad.getEstado());
            propiedadActual.setIdArrendador(propiedad.getIdArrendador());

            propiedadUpdate = propiedadService.save(propiedadActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar la propiedad en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La propiedad ha sido actualizado con exito!");
        response.put("propiedad", propiedadUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/propiedad/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            propiedadService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar la propiedad en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La propiedad fue eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
