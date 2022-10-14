package com.usa.palcosappfinal1.repository.crudrepository;

import com.usa.palcosappfinal1.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
