package daoApi;

import org.springframework.data.repository.CrudRepository;

import model.Inmueble;

public interface InmuebleDaoAPI extends CrudRepository<Inmueble, Integer> {

}
