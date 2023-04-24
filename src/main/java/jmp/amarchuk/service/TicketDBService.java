package jmp.amarchuk.service;

import jmp.amarchuk.DAO.TicketDaoDBImpl;
import jmp.amarchuk.model.Category;
import jmp.amarchuk.model.Event;
import jmp.amarchuk.model.Ticket;
import jmp.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketDBService implements TicketService {

    @Autowired
    TicketDaoDBImpl ticketDaoListDB;

    public TicketDBService(TicketDaoDBImpl ticketDaoListDB) {
        this.ticketDaoListDB = ticketDaoListDB;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public long getEventId() {
        return 0;
    }

    @Override
    public void setEventId(long eventId) {

    }

    @Override
    public long getUserId() {
        return 0;
    }

    @Override
    public void setUserId(long userId) {

    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public void setCategory(Category category) {

    }

    @Override
    public int getPlace() {
        return 0;
    }

    @Override
    public void setPlace(int place) {

    }

    public Ticket bookTicket(long userId, long eventId, int place, jmp.amarchuk.model.Category category) {
        return ticketDaoListDB.bookTicket(userId,eventId, place, category);
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDaoListDB.getBookedTickets(user,pageSize,pageNum);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDaoListDB.getBookedTickets(event,pageSize,pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketDaoListDB.cancelTicket(ticketId);
    }

}
