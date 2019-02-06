package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository) {
        return (arg) -> {

            customerRepository.save(new Customer("Rufaida", "Mugalli"));
            customerRepository.save(new Customer("Gabriel", "Katzenbecher"));
            customerRepository.save(new Customer("Jön", "Schnecker"));
            customerRepository.save(new Customer("Luca", "Monaco"));
            customerRepository.save(new Customer("Jan", "weissnicht"));

            //fetch all customer
            log.info("Find Customer by name : ");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());

            }

            //fetch all users by the last name
            customerRepository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));


        };
    }
}
