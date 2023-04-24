package jmp.amarchuk;

import jmp.amarchuk.model.Event;
import jmp.amarchuk.model.Ticket;
import jmp.amarchuk.model.User;
import jmp.amarchuk.facade.BookingFacadeImpl;
import jmp.amarchuk.model.Category;
import jmp.amarchuk.service.EventDBService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;


public class ApplicationSpring {

    private static final Logger logger =   LoggerFactory.getLogger(ApplicationSpring.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("configuration.xml");
        logger.info("Testing p-properties for bean in xml configuration. STARTING...");
        Event propertyTestBean = applicationContext.getBean("propertyTestEvent", Event.class);
        String testTitle=propertyTestBean.getTitle();
        long testId=propertyTestBean.getId();
        logger.warn("Testing p-properties: " +'\n'+ "Title is '" + testTitle +'\n'+"Id is '" + testId +"'"+'\n');
        logger.warn("Testing p-properties: testTitle is - {}. Id is - {}",testTitle, testId);
        logger.info("Testing p-properties successfuly COMPLETED!");



        BookingFacadeImpl facadeBean = applicationContext.getBean("facadeImpl", BookingFacadeImpl.class);
        EventDBService eventDBServiceBean=applicationContext.getBean("eventDBService", EventDBService.class);

        logger.info("Getting all events: {} ",eventDBServiceBean.getAllEvents());

        Event eventWithId2=facadeBean.getEventById(2);
        logger.info("Getting ivents with eventId=2. Event - {}",eventWithId2);

        List<Event> eventTtileList= facadeBean.getEventsByTitle("Birthday",1,1);
        logger.info("Getting ivents with title=Birhday. Events : {}",eventTtileList);


        logger.info("Getting all users from db - {}",facadeBean.getAllUsers().size());
        User userSam = new User(5,"Sam","sam@gmail.com");
        logger.info("Creating new user {}",userSam.getName());
        facadeBean.createUser(userSam);
        logger.info("User {} was successfully created",userSam.getName());
        logger.info("Getting all users from db after creating new one - {}",facadeBean.getAllUsers().size());


        logger.info("Check if user {} has been already bought any ticket...",userSam.getName());
        List<Ticket> ticketList=facadeBean.getBookedTickets(userSam,1,1);
        logger.info("User {} has {} ticket(s)",userSam.getName(),ticketList.size());

        facadeBean.bookTicket(5,1,2,Category.BAR);
        logger.info("User {} has booked a ticket",userSam.getName());

        User anastasia=facadeBean.getUsersByName("Anastasia",1,1).get(0);
        long numOfTicketsAnastasia=facadeBean.getBookedTickets(anastasia,1,1).size();
        logger.info("User {} has {} ticket(s)","Anastasia",numOfTicketsAnastasia);

        logger.info("Getting all events. Numer of events is {}", facadeBean.getAllEvents().size());
        Event newEvent=new Event ((long) 10,"New event Title", new Date(01/01/2025));
        facadeBean.createEvent(newEvent);
        logger.info("Getting all events after creating one more. Numer of events is {}", facadeBean.getAllEvents().size());

        logger.info("Getting all users from db before deleting user - {}",facadeBean.getAllUsers().size());
        logger.info("Deleting user {}", facadeBean.getUserById(1).getName());
        facadeBean.deleteUser(1);
        logger.info("Getting all users from db after deleting user - {}",facadeBean.getAllUsers().size());


    }
}
