package rewardSystemFlipkart.dao;

import rewardSystemFlipkart.entity.Member;

public interface MemberDao {

    public void addMemberInDb(Member member);

    public Member getMemberFromDb(Integer member);
}
