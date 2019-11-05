package com.invillia.acme.repository;

import com.invillia.acme.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
