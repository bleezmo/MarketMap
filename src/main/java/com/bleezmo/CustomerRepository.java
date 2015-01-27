package com.bleezmo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 1/27/15
 * Time: 10:30 AM
 * #TODO
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName);
}
