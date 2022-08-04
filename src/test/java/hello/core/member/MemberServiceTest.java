package hello.core.member;

import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        //Assertions.assertThat(member).isEqualTo(findMember);
        assertEquals(member,findMember,"둘이 같아야 합니다!");

    }
}
