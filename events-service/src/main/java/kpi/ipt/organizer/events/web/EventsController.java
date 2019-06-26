package kpi.ipt.organizer.events.web;

import kpi.ipt.organizer.events.exceptions.EventNotFoundException;
import kpi.ipt.organizer.events.model.Event;
import kpi.ipt.organizer.events.model.EventProperties;
import kpi.ipt.organizer.events.service.EventsService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @RequestMapping(path = "{userId}", method = RequestMethod.GET)
    public List<Event> getUserEvents(
            @PathVariable("userId") long userId,
            @RequestParam(name = "from", required = false) Long from,
            @RequestParam(name = "to", required = false) Long to
    ) {
        Date fromDate = toDateOrNull(from);
        Date toDate = toDateOrNull(to);

        return eventsService.getUserEvents(userId, fromDate, toDate);
    }

    private static Date toDateOrNull(Long timestamp) {
        return (timestamp == null) ? null : new Date(timestamp);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "{userId}", method = RequestMethod.POST)
    public Map<String, String> createEvent(
            @PathVariable("userId") long userId,
            @RequestBody EventProperties eventProperties
    ) {
        Event createdEvent = eventsService.createEvent(userId, eventProperties);

        return Collections.singletonMap("eventId", createdEvent.getId());
    }

    @RequestMapping(path = "/{userId}/{eventId}", method = RequestMethod.DELETE)
    public SuccessResponse deleteEvent(
            @PathVariable("userId") long userId,
            @PathVariable("eventId") String eventId
    ) {
        if (!eventsService.deleteEvent(userId, eventId)) {
            throw new EventNotFoundException();
        }

        return SuccessResponse.INSTANCE;
    }

    @Getter
    private static class SuccessResponse {

        private static final SuccessResponse INSTANCE = new SuccessResponse();

        private final boolean success = true;
    }
}
