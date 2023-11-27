package zw.co.equals.customersupportservice.service;

import zw.co.equals.customersupportservice.dto.TicketDto;

import java.util.List;

public interface TicketService {

    TicketDto create(TicketDto ticketDto);
    TicketDto close(String ticketDto);
    List<TicketDto> viewOpen(String assignee);
}
