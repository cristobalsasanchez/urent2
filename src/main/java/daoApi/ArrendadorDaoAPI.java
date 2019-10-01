package daoApi;

import org.springframework.data.repository.CrudRepository;

import model.Arrendador;

public interface ArrendadorDaoAPI extends CrudRepository<Arrendador, String> {

}
