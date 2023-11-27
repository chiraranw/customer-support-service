package zw.co.equals.customersupportservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.equals.customersupportservice.model.Ticket;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findByAssignee(String assignee);
}
