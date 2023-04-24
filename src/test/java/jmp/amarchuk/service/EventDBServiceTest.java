package jmp.amarchuk.service;

import jmp.amarchuk.DAO.EventDaoDBImpl;
import jmp.amarchuk.model.Event;
import jmp.amarchuk.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventDBServiceTest {

    private static Logger logger= LoggerFactory.getLogger(EventDBServiceTest.class);
    Event event;
    Event event2;
    Event event3;
    List<Event> list;

    @InjectMocks
    EventDBService eventService;

    @Mock
    EventDaoDBImpl eventDaoList;

    @Before
    public void init() {
        logger.info("Adding test user to list ");
        event = new Event((long) 1, "Event", new Date("20/04/2023"));
        event2 = new Event((long) 2, "Event", new Date("20/04/2023"));
        event3 = new Event((long) 3, "Event3", new Date("20/04/2023"));
        eventDaoList.createEvent(event);
        eventDaoList.createEvent(event2);

    }

    @Test
    void getEventById() {


        List<Event> list = Arrays.asList(event, event2);

        when(eventDaoList.getEventsByTitle("Event", 1, 1)).thenReturn(list);

        List<Event> mock = eventService.getEventsByTitle("Event", 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void getEventsByTitle() {

        List <Event> eventList=new ArrayList<>();
        eventList.add(event3);

        when(eventDaoList.getEventsByTitle("Event3", 1, 1)).thenReturn(eventList);

        List<Event> mock = eventService.getEventsByTitle("Event3", 1, 1);
        assertEquals(eventList.size(), mock.size());

    }

    @Test
    void getEventsForDay() {

        List <Event> eventList=new ArrayList<>();
        eventList.add(event);
        when(eventDaoList.getEventsForDay(new Date("20/04/2023"), 1, 1)).thenReturn(eventList);

        List<Event> mock = eventService.getEventsForDay(new Date("20/04/2023"), 1, 1);
        assertEquals(eventList.size(), mock.size());

    }

    @Test
    void createEvent() {

        Event event2 = new Event((long) 1, "Mock", new Date("20/04/2023"));
        when(eventDaoList.createEvent(event2)).thenReturn(event2);
        assertEquals(eventService.createEvent(event2), event2);

    }

    @Test
    void updateEvent() {
        Event updatedEvent= new Event((long) 1, "Updated Event", new Date("20/04/2023"));
        when(eventDaoList.updateEvent(updatedEvent)).thenReturn(updatedEvent);
        Assertions.assertEquals(eventService.updateEvent(updatedEvent),updatedEvent);
    }

    @Test
    void deleteEvent() {

        when(eventDaoList.deleteEvent(1)).thenReturn(true);
        Assertions.assertTrue(eventService.deleteEvent(1));
    }

    @Test
    void deleteAllEvents() {

        when(eventDaoList.deleteAllEvents()).thenReturn(true);
        Assertions.assertTrue(eventService.deleteAllEvents());
    }
}