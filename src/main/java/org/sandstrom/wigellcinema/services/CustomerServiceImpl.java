package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.dao.CustomerRepository;
import org.sandstrom.wigellcinema.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRep){
        customerRepository = customerRep;
    }
    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    @Override
    public Customer findById(int id){
        Optional<Customer> c = customerRepository.findById(id);
        Customer customer = null;
        if(c.isPresent()){
            customer = c.get();
        }
        else{
            throw new RuntimeException("Kund med kundid " + id + " hittades inte.");
        }
        return customer;
    }
    @Override
    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id){
        customerRepository.deleteById(id);
    }




}
