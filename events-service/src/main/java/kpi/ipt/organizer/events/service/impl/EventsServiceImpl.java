package kpi.ipt.organizer.events.service.impl;

import kpi.ipt.organizer.events.model.Event;
import kpi.ipt.organizer.events.model.EventProperties;
import kpi.ipt.organizer.events.repository.EventsRepository;
import kpi.ipt.organizer.events.service.EventsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    public EventsServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public Event createEvent(long userId, EventProperties eventProperties) {
        return eventsRepository.insert(new Event(userId, eventProperties));
    }

    @Override
    public boolean deleteEvent(long userId, String eventId) {
        int deletedEvents = eventsRepository.deleteByIdAndUserId(userId, eventId);

        return deletedEvents != 0;
    }

    @Override
    public List<Event> getUserEvents(long userId, Date from, Date to) {
        return eventsRepository.findAllByUserIdAndStartTimeOrderByStartTime(userId, from, to);
    }
}
