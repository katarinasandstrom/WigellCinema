package org.sandstrom.wigellcinema.controllers;

import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.services.CustomerService;
import org.sandstrom.wigellcinema.services.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerSer){
        customerService = customerSer;
    }

    @GetMapping("/v1/customers")
    public List<Customer>findAll(){
        return customerService.findAll();
    }

    @GetMapping("/v1/customers/{id}")
    public Customer getCustomer (@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new RuntimeException("Kund med id " + id + " hittades inte.");
        }
        return customer;
    }

    @PostMapping("/v1/customers")
    public Customer addCustomer(@RequestBody Customer c) {
        c.setId(0);
        return customerService.save(c);
    }

    @DeleteMapping ("v1/customers/{id}")
    public String deleteCustomer(@PathVariable int id){
       Customer customer = customerService.findById(id);
       if (customer == null){
           throw new RuntimeException("Kund med id: " + id + " hittades inte.");
       }
       customerService.deleteById(id);
       return "Kund med id: " + id + " är raderad.";
    }

    @PutMapping("/v1/customers/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer c) {
        // Hämta den befintliga kunden
        Customer existingCustomer = customerService.findById(id);

        // Uppdatera fälten i den befintliga kunden
        existingCustomer.setFirstName(c.getFirstName());
        existingCustomer.setLastName(c.getLastName());
        existingCustomer.setPhoneNumber(c.getPhoneNumber());
        existingCustomer.setDateOfBirth(c.getDateOfBirth());
        existingCustomer.setEmail(c.getEmail());
        existingCustomer.setUsername(c.getUsername());
        existingCustomer.setPassword(c.getPassword());
        existingCustomer.setRole(c.getRole());
      //adress

        // Spara den uppdaterade kunden
        return customerService.save(existingCustomer);
    }

}
