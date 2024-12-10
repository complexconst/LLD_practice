package RewardSystemFlipkart;

import RewardSystemFlipkart.dao.EventDao;
import RewardSystemFlipkart.dao.Impl.EventDaoImpl;
import RewardSystemFlipkart.dao.Impl.MemberDaoImpl;
import RewardSystemFlipkart.dao.MemberDao;
import RewardSystemFlipkart.services.AdminService;
import RewardSystemFlipkart.services.EventService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDaoImpl();
        EventDao eventDao = new EventDaoImpl();
        AdminService adminService = new AdminService(memberDao, eventDao);
        EventService eventService = new EventService(eventDao, memberDao);

        adminService.addMember(1, "akshay", 100);
        adminService.addMember(2, "chris", 5000);

        adminService.addEvent(1, "BBD", "IPhone-14");

        adminService.registerMember(1, 1);

        eventService.submitBid(1, 1, Arrays.asList(100, 200, 400, 500, 600));
        eventService.submitBid(2, 1, Arrays.asList(100, 200, 400, 500));
        eventService.submitBid(10, 1, Arrays.asList(100, 200, 300, 400, 500));

        eventService.declareWinner(1);


        adminService.showWinners();
    }
}
