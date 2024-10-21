package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.dao.CustomerRepository;
import org.sandstrom.wigellcinema.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRep){
        customerRepository = customerRep;
    }

    @Override
    public List<Customer> findAll(){
        logger.info("All registered customers have been listed");
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
            throw new RuntimeException("Customer with id " + id + " could not be found.");
        }
        logger.info("Customer with id " + " was listed.");
        return customer;
    }
//    @Override
//    public Customer save (Customer customer){
//        String encodedPassword = passwordEncoder.encode(customer.getPassword());
//        customer.setPassword(encodedPassword);
//        return customerRepository.save(customer);
//    }

    @Override
    public Customer save (Customer customer){
        logger.info("New customer was saved.");
        return customerRepository.save(customer);
    }


    @Override
    public void deleteById(int id){
        logger.info("Customer with id " + id + " was deleted.");
        customerRepository.deleteById(id);
    }




}
