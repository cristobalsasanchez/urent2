package com.proyecto.urent.Controller;

import com.proyecto.urent.Model.Entity.Inmueble;
import com.proyecto.urent.Model.Service.IInmuebleService;
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
public class InmuebleController {
    @Autowired
    private IInmuebleService inmuebleService;

    @GetMapping("/inmueble")
    public List<Inmueble> index(){
        return inmuebleService.findAll();
    }

    @GetMapping("/inmueble/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> show(@PathVariable Integer id){

        Inmueble inmueble = null;
        Map<String, Object> response = new HashMap<>();

        try{
            inmueble = inmuebleService.findById(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(inmueble == null){
            response.put("mensaje", "El inmueble ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Inmueble>(inmueble, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)


    @PostMapping("/inmueble")
    public ResponseEntity<?> create(@Valid @RequestBody Inmueble inmueble, BindingResult result) {

        Inmueble inmueble1 = null;
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
            inmueble1 = inmuebleService.save(inmueble);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El inmueble ha sido creado con exito!");
        response.put("inmueble", inmueble1);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/inmueble/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Inmueble inmueble, BindingResult result, @PathVariable Integer id){

        Inmueble inmuebleActual = inmuebleService.findById(id);

        Inmueble inmuebleUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(inmuebleActual == null){
            response.put("mensaje", "El inmueble ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            inmuebleActual.setAgua(inmueble.getAgua());
            inmuebleActual.setCocina(inmueble.getCocina());
            inmuebleActual.setEstado(inmueble.getEstado());
            inmuebleActual.setDescripcion(inmueble.getDescripcion());
            inmuebleActual.setDireccion(inmueble.getDireccion());
            inmuebleActual.setDisponibilidad(inmueble.getDisponibilidad());
            inmuebleActual.setEstacionamiento(inmueble.getEstacionamiento());
            inmuebleActual.setIdPropiedad(inmueble.getIdPropiedad());
            inmuebleActual.setGas(inmueble.getGas());
            inmuebleActual.setLuz(inmueble.getLuz());
            inmuebleActual.setWifi(inmueble.getWifi());
            inmuebleActual.setNroBanos(inmueble.getNroBanos());
            inmuebleActual.setNroHabitaciones(inmueble.getNroHabitaciones());
            inmuebleActual.setPrecioMensual(inmueble.getPrecioMensual());

            inmuebleUpdate = inmuebleService.save(inmuebleActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar el inmueble en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El inmueble ha sido actualizado con exito!");
        response.put("inmueble", inmuebleUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/inmueble/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();

        try{
            inmuebleService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el inmueble en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El inmueble fue eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
