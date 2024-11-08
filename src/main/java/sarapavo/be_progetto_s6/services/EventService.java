//package sarapavo.be_progetto_s6.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import sarapavo.be_progetto_s6.entities.Event;
//import sarapavo.be_progetto_s6.entities.User;
//import sarapavo.be_progetto_s6.exceptions.BadRequestException;
//import sarapavo.be_progetto_s6.payloads.NewEventDTO;
//import sarapavo.be_progetto_s6.repositories.EventRepository;
//
//@Service
//public class EventService {
//    @Autowired
//    private EventRepository eventRepository;
//
//    public Event createEvent (NewEventDTO body){
//        this.eventRepository.findByOrganizer(body.organizerId())//.equals(
//
////                event -> {
////                    throw new BadRequestException("L'id " + body.organizerId() + " non valido!");
////                }
// //       );
//
//        Event newEvent = new Event(body.title(), body.description(), body.date(), body.location(), body.numberOfPeople(), body.organizerId());
//
//        Event savedEvent = this.eventRepository.save(newEvent);
//
//
//    }
//}
