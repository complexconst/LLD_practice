package RewardSystemFlipkart.dao;

import RewardSystemFlipkart.entity.Member;

public interface MemberDao {

    public void addMemberInDb(Member member);

    public Member getMemberFromDb(Integer member);
}
