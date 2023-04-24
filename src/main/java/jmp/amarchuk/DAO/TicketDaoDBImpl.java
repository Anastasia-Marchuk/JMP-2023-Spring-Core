package jmp.amarchuk.DAO;

import jmp.amarchuk.model.Category;
import jmp.amarchuk.model.Event;
import jmp.amarchuk.model.Ticket;
import jmp.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TicketDaoDBImpl implements TicketDao {

    @Autowired
    private Map<String, Ticket> tickets;

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        Long id = (Long)user.getId();
        return tickets.values().stream().filter(o -> o.getUserId() == id).collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        long id=event.getId();
        return tickets.values().stream().filter(o -> o.getEventId() == id).collect(Collectors.toList());
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return tickets.keySet().removeIf(key -> key.equals("ticket" +ticketId));
    }


    public void setTickets(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        Ticket ticket = new Ticket(eventId, userId, category, place);
        long newId=tickets.size()+1;
        ticket.setId(newId);
        tickets.put("ticket" + ticket.getId(), ticket);
        return ticket;
    }


    public Map<String, Ticket>  getAllTickets() {
        return tickets;
    }
}
