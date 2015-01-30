package com.bleezmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MarketMapApplication {

    @Bean
    public MessageService getMessageService(){
        return new EmailService();
    }
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MarketMapApplication.class, args);
        CustomerRepository repository = context.getBean(CustomerRepository.class);

        repository.save(new Customer("Jack","Bauer"));
        repository.save(new Customer("jesus","christ"));

        Iterable<Customer> customers = repository.findAll();
        for(Customer customer : customers){
            System.out.println(customer);
        }

        customers = repository.findByLastName("Bauer");
        for(Customer customer : customers){
            System.out.println(customer);
        }

        customers = repository.findByFirstName("jesus");
        for(Customer customer : customers) {
            System.out.println(customer);
        }

        MessageComponent mybean = context.getBean(MessageComponent.class);
        mybean.processMessage("hello email bean");
        // context.close();
    }
}
