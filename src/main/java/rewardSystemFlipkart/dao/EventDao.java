package rewardSystemFlipkart.dao;

import rewardSystemFlipkart.entity.Event;

import java.util.Map;

public interface EventDao {


    public void addEventInDb(Event event);

    public Event getEventFromDb(Integer event);

    public Map<Integer, Event> getAllEvents();
}