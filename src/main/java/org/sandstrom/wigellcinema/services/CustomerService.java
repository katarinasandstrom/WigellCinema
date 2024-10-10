package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int id);

    Customer save(Customer customer);

    void deleteById(int id);

}
