package flight_booking.backend.controllers.ticket;

import flight_booking.backend.models.Ticket;
import flight_booking.backend.service.TicketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
        this.ticketMapper = new TicketMapper();
    }

    @ApiOperation(value = "Get all user's tickets")
    @GetMapping("/{id}")
    ResponseEntity<List<TicketDto>> getAllUsersTicket(@PathVariable Long id) {

        List<Ticket> tickets = ticketService.findAllTicketFromUserId(id);

        ArrayList<TicketDto> ticketDtos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDtos.add(ticketMapper.map(ticket));
        }
        System.out.println(ticketDtos);
        return ResponseEntity.ok(ticketDtos);
    }
}
