package rewardSystemFlipkart.dao.Impl;

import rewardSystemFlipkart.dao.EventDao;
import rewardSystemFlipkart.entity.Event;

import java.util.HashMap;
import java.util.Map;

public class EventDaoImpl implements EventDao {

    Map<Integer, Event> events;


    public EventDaoImpl() {
        events = new HashMap<Integer, Event>();
    }

    public void addEventInDb(Event event) {
        events.put(event.getId(), event);
    }

    public Event getEventFromDb(Integer eventId) throws RuntimeException {
        if(!events.containsKey(eventId)) {
            throw new RuntimeException("Event with id " + eventId + " not found");
        }
        return events.get(eventId);
    }

    public Map<Integer, Event> getAllEvents() {
        return events;
    }
}
