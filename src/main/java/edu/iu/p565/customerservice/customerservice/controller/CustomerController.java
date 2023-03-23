package edu.iu.p565.customerservice.customerservice.controller;


import edu.iu.p565.customerservice.customerservice.model.Customer;
import edu.iu.p565.customerservice.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public int create(@RequestBody Customer customer){
        return repository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer, @PathVariable int id){
        repository.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.delete(id);
    }
}
