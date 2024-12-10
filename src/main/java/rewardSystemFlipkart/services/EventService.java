package rewardSystemFlipkart.services;

import rewardSystemFlipkart.dao.EventDao;
import rewardSystemFlipkart.dao.MemberDao;
import rewardSystemFlipkart.entity.Bid;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EventService {


    EventDao eventDao;
    MemberDao memberDao;


    public EventService(EventDao eventDao, MemberDao memberDao) {
        this.eventDao = eventDao;
        this.memberDao = memberDao;
    }



    public void submitBid(Integer memberId, Integer eventId, List<Integer> bidAmts) {
        Bid bid = new Bid(memberId, eventId);
        bid.getBidAmts().addAll(bidAmts);
        try {
            int maxBidAmt = 0;
            for(Integer bidAmt : bidAmts) {
                maxBidAmt = Math.max(maxBidAmt, bidAmt);
            }
            var event = eventDao.getEventFromDb(eventId);
            var member = memberDao.getMemberFromDb(memberId);
            if(member.getSupercoins() < maxBidAmt) {
                System.out.println("SuperCoin not enough to place bid");
                return;
            }
            var membersRegisteredForEvent = event.getMemberIds();

            if(membersRegisteredForEvent.containsKey(memberId)) {
                if(membersRegisteredForEvent.get(memberId) == null) {
                    membersRegisteredForEvent.put(memberId, bid);
                    System.out.println("BIDS placed successfully");
                }
                else {
                    System.out.println("Bid Already placed");
                }
            }
            else {
                System.out.println("member not registered");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void declareWinner(Integer eventId) {
        try {
            var event = eventDao.getEventFromDb(eventId);
            var membersRegisteredForEvent = event.getMemberIds();
            Integer minBid = Integer.MAX_VALUE;
            Integer winnerId = null;
            LocalDateTime dateTime = LocalDateTime.now();
            for(Map.Entry entry : membersRegisteredForEvent.entrySet()) {
                Integer memberId = (Integer) entry.getKey();
                Bid bid = (Bid) entry.getValue();
                if(bid == null) continue;
                for(Integer bidAmt : bid.getBidAmts()) {
                    if(bidAmt < minBid) {
                        minBid = bidAmt;
                        winnerId = memberId;
                        dateTime = bid.getBidTime();
                    }
                    else {
                        if(bidAmt.equals(minBid)) {
                            if(dateTime.isAfter(bid.getBidTime())) {
                                winnerId = memberId;
                                dateTime = bid.getBidTime();
                            }
                        }
                    }
                }
            }
            if(winnerId != null) {
                var winner = memberDao.getMemberFromDb(winnerId);
                System.out.println(winner.getName() + "wins: " + event.getPrize().getName() + " with lowest bid " + minBid);
            }
            else {
                System.out.println("No Winner found for event id: " + eventId);
                return;
            }
            event.setWinnerId(winnerId);
            eventDao.addEventInDb(event);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
