package kpi.ipt.organizer.events.web;

import kpi.ipt.organizer.events.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MappedEventRepository extends MongoRepository<Event, String> {
}
