package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o() {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discountVIP = discountPolicy.discount(memberVIP, 10000);
        //then
        assertThat(discountVIP).isEqualTo(1000);
    }

    @Test
    void vip_x() {
        //given
        Member memberBASIC = new Member(1L, "memberBASIC", Grade.BASIC);
        //when
        int discountBASIC = discountPolicy.discount(memberBASIC, 10000);
        //then
        assertThat(discountBASIC).isEqualTo(0);
    }
}