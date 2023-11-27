package zw.co.equals.customersupportservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Ticket {
    @Id
    private String id;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateClosed;
    private TicketStatus ticketStatus;
    private String assignee;
}
