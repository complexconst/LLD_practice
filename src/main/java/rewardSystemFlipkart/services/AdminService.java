package RewardSystemFlipkart.services;

import RewardSystemFlipkart.dao.EventDao;
import RewardSystemFlipkart.dao.MemberDao;
import RewardSystemFlipkart.entity.Event;
import RewardSystemFlipkart.entity.Member;
import RewardSystemFlipkart.entity.Prize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AdminService {

    final int MIN_EVENTS_TO_VIEW = 5;
    MemberDao memberDao;
    EventDao eventDao;


    public AdminService(MemberDao memberDao, EventDao eventDao) {
        this.memberDao = memberDao;
        this.eventDao = eventDao;
    }

    public void addMember(int id, String name, Integer supercoins) {
        Member member = new Member(id, name, supercoins);
        try {
            memberDao.addMemberInDb(member);
            System.out.println(member.getName() + " added successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEvent(int id, String name, String prizeName) {
        Prize prize = new Prize(prizeName);
        Event event = new Event(id, name, prize);
        try {
            eventDao.addEventInDb(event);
            System.out.println(event.getName() + " with prize" + prize.getName() + " added successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerMember(Integer memberId, Integer eventId) {
        try {
            var event = eventDao.getEventFromDb(eventId);
            var member = memberDao.getMemberFromDb(memberId);
            var eventMemberIdHashmap = event.getMemberIds();
            eventMemberIdHashmap.put(memberId, null);
            event.setMemberIds(eventMemberIdHashmap);
            eventDao.addEventInDb(event);

            System.out.println(member.getName() + "registered to event" + event.getName() +  " successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showWinners() {
        var allEvents = eventDao.getAllEvents();
        List<Event> events = new ArrayList<>();
        for(Map.Entry entry : allEvents.entrySet()) {
            events.add((Event)entry.getValue());
        }

        events.sort(Comparator.comparing(a -> a.getDate()));
        events.subList(0, Math.min(MIN_EVENTS_TO_VIEW, events.size()));
        System.out.println("Winners : ");
        System.out.println(events);
    }
}
