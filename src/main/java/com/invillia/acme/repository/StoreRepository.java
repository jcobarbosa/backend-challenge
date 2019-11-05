package com.invillia.acme.repository;

import com.invillia.acme.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> {

    Store findByName(String name);

}
