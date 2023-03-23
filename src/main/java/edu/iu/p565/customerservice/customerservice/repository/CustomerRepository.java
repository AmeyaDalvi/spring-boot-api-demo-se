package edu.iu.p565.customerservice.customerservice.repository;
import edu.iu.p565.customerservice.customerservice.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll(){
        return customers;
    }

    public int create(Customer customer){
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }

    public void update(Customer customer, int id){
        Customer cust = getCustomerById(id);
        if (cust != null){
            cust.setName(customer.getName());
            cust.setEmail((customer.getEmail()));
        }
//        else{
//            return ("Invalid id, please try again");
//        }
//        return
    }

    private Customer getCustomerById(int id){
        return customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void delete(int id){
        Customer cust = getCustomerById(id);
        if(cust != null){
            customers.remove(cust);
        }
    }


}
