package com.bar.newtonbar.repository;

import com.bar.newtonbar.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
