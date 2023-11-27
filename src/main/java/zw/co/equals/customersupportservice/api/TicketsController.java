package zw.co.equals.customersupportservice.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.equals.customersupportservice.dto.TicketDto;
import zw.co.equals.customersupportservice.service.TicketService;

@RestController
@RequestMapping("/api/v1.0/support")
public class TicketsController {

    private final TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TicketDto ticketDto){
        return  new ResponseEntity<>(ticketService.create(ticketDto), HttpStatus.CREATED);
    }

    @PostMapping("/close/{id}")
    public ResponseEntity<?> close(@PathVariable("id") String id){
        return  new ResponseEntity<>(ticketService.close(id) ,HttpStatus.OK);
    }

    @GetMapping("/view/{assignee}")
    public ResponseEntity<?> viewOpen(@PathVariable("assignee") String assignee){
        return  new ResponseEntity<>(ticketService.viewOpen(assignee) ,HttpStatus.OK);
    }
}
