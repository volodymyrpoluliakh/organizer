package kpi.ipt.organizer.events.web;

import kpi.ipt.organizer.events.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/events/test")
@RestController
public class TestEventsController {

    @Autowired
    private MappedEventRepository eventRepository;

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
