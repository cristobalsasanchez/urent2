package daoApi;

import org.springframework.data.repository.CrudRepository;

import model.Arrendatario;

public interface ArrendatarioDaoAPI extends CrudRepository<Arrendatario, String> {

}
