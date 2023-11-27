package zw.co.equals.customersupportservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import zw.co.equals.customersupportservice.dto.TicketDto;
import zw.co.equals.customersupportservice.exception.TicketNotFoundException;
import zw.co.equals.customersupportservice.model.Ticket;
import zw.co.equals.customersupportservice.model.TicketStatus;
import zw.co.equals.customersupportservice.repository.TicketRepository;
import zw.co.equals.customersupportservice.service.TicketService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDto create(TicketDto ticketDto) {
        log.info("Creating a ticket: {}", ticketDto);
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        ticket.setTicketStatus(TicketStatus.OPEN);
        Ticket savedTicket = ticketRepository.save(ticket);
        return modelMapper.map(savedTicket, TicketDto.class);
    }

    @Override
    public TicketDto close(String id) {
        Ticket ticket = ticketRepository
                .findTicketById(id)
                .orElseThrow(() -> new TicketNotFoundException("Could not find ticket :" + id));
        ticket.setTicketStatus(TicketStatus.CLOSED);
        Ticket savedTicket = ticketRepository.save(ticket);
        log.info("Ticket updated successfully: {}", savedTicket);
        return modelMapper.map(savedTicket, TicketDto.class);
    }

    @Override
    public List<TicketDto> viewOpen(String assignee) {
        List<Ticket> tickets = ticketRepository
                .findByAssignee(assignee);
        if (tickets.isEmpty()) {
            return List.of();
        }
        return tickets
                .stream()
                .map(t -> modelMapper.map(t, TicketDto.class))
                .collect(Collectors.toList());

    }
}
