package jmp.amarchuk.DAO;

import jmp.amarchuk.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventDaoDBImpl implements EventDao {

    @Autowired
    private List<Event> events;

    public EventDaoDBImpl(List<Event> events) {
        this.events = events;
    }

    @Override
    public Event getEventById(long eventId) {
        return events.stream().filter(o -> o.getId()==eventId).findAny().get();
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getDate().equals(day)).collect(Collectors.toList());
    }

    public List<Event> getAllEvents() {
        return events.stream().collect(Collectors.toList());
    }

    @Override
    public Event createEvent(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        events.remove(events.stream().filter(o -> o.getId()==event.getId()).collect(Collectors.toList()).get(0));
        events.add(event);
        return events.get((int) event.getId());
    }

    @Override
    public boolean deleteEvent(long eventId) {
        for (Event e : events) {
            if(e.getId()==eventId){
                return events.remove(e);
            }
        }
        return false;
    }

    @Override
    public boolean deleteAllEvents() {
        for (int i = events.size(); i>=0 ; i--) {
            if(events.isEmpty()){
                return true;
            }
            events.remove(events.get(i-1));
        }
        return events.size() == 0;
    }

    @Override
    public int sizeEvent() {
        return events.size();
    }


}
