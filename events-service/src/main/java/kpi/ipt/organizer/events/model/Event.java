package kpi.ipt.organizer.events.model;

import kpi.ipt.organizer.color.ColorUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Event.COLLECTION_NAME)
public class Event extends EventProperties {

    public static final String COLLECTION_NAME = "events";

    @Id
    private String id;
    private long userId;

    public Event(long userId, EventProperties eventProperties) {
        super(eventProperties);
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Event(" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", start=" + start +
                ", end=" + end +
                ", title='" + title + '\'' +
                ", color=" + ColorUtils.toWebString(color) +
                ")";
    }
}
