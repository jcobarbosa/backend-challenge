package com.invillia.acme.repository;

import com.invillia.acme.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
