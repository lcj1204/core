package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {

    MemberService memberService;

    /**
     * @BeforeEach : 아래 @Test 마다 실행됨.
     */
    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
