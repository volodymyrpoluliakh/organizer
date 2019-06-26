package kpi.ipt.organizer.events.service;

import kpi.ipt.organizer.events.model.Event;
import kpi.ipt.organizer.events.model.EventProperties;

import java.util.Date;
import java.util.List;

public interface EventsService {

    Event createEvent(long userId, EventProperties eventProperties);

    boolean deleteEvent(long userId, String eventId);

    List<Event> getUserEvents(long userId, Date from, Date to);
}
