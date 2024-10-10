package org.sandstrom.wigellcinema.dao;

import org.sandstrom.wigellcinema.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
