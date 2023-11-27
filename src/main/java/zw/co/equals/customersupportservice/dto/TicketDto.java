package zw.co.equals.customersupportservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import zw.co.equals.customersupportservice.model.TicketStatus;

import java.time.LocalDateTime;

@Data
public class TicketDto {
    private String id;
    @NotBlank(message = "Description is required, cannot be null or empty.")
    private String description;
    private LocalDateTime dateCreated= LocalDateTime.now();
    private TicketStatus ticketStatus;
    @NotBlank(message = "Assignee is required, cannot be null or empty.")
    private String assignee;
}
