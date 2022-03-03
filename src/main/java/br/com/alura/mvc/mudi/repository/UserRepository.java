package br.com.alura.mvc.mudi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
