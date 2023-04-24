package jmp.amarchuk.service;

import jmp.amarchuk.DAO.EventDaoDBImpl;
import jmp.amarchuk.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventDBService implements EventService {

    @Autowired
    EventDaoDBImpl eventDaoDBImpl;

    public EventDBService(EventDaoDBImpl eventDaoDBImpl) {
        this.eventDaoDBImpl = eventDaoDBImpl;
    }

    public Event getEventById(long eventId) {
        return eventDaoDBImpl.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDaoDBImpl.getEventsByTitle(title, pageSize, pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDaoDBImpl.getEventsForDay(day, pageSize, pageNum);
    }

    public List<Event> getAllEvents() {
        return eventDaoDBImpl.getAllEvents();
    }

    public Event createEvent(Event event) {
        return eventDaoDBImpl.createEvent(event);
    }

    public Event updateEvent(Event event) {
        return eventDaoDBImpl.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        return eventDaoDBImpl.deleteEvent(eventId);
    }

    public boolean deleteAllEvents() {
        return eventDaoDBImpl.deleteAllEvents();
    }

    @Override
    public List<Event> getAllEvent() {
        return eventDaoDBImpl.getAllEvents();
    }

}
