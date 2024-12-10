package RewardSystemFlipkart.dao.Impl;

import RewardSystemFlipkart.dao.MemberDao;
import RewardSystemFlipkart.entity.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberDaoImpl implements MemberDao {

    Map<Integer, Member> members;


    public MemberDaoImpl() {
        members = new HashMap<Integer, Member>();
    }

    public void addMemberInDb(Member member) {
        members.put(member.getId(), member);
    }

    public Member getMemberFromDb(Integer member) throws RuntimeException {
        if(!members.containsKey(member)) {
            throw new RuntimeException("Member with id " + member + " not found");
        }
        return members.get(member);
    }

}
