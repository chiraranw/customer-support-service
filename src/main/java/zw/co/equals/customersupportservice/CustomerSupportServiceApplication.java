package zw.co.equals.customersupportservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import zw.co.equals.customersupportservice.model.Ticket;
import zw.co.equals.customersupportservice.model.TicketStatus;
import zw.co.equals.customersupportservice.repository.TicketRepository;

@SpringBootApplication
public class CustomerSupportServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSupportServiceApplication.class, args);
	}

}
