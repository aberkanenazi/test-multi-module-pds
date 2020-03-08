package project.com.service;


import project.com.model.Customer;
import org.springframework.stereotype.Service;
import project.com.persistance.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ServiceImpl<Customer> {


    private CustomerRepository customerRepository;


    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(String id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(String id) {

    }
}
