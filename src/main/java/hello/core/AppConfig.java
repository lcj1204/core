package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration : 스프링 컨테이너는 이게 붙은 Class를 설정 정보로 사용함.
 */
@Configuration
public class AppConfig {
    /**
     * 이렇게 선언하는게 뭐하는건지 모르겠음
     * 클래스의 객체를 만드는건가? 생성자인가?
     * @Bean : 각 메소드마다 붙임, 그러면 각 메소드들이 스프링 컨테이너에 등록이됨.
     * 스프링 컨테이너에서는 각 매소드의 객체를 생성하고 관리해줌.
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                DiscountPolicy());
    }

    @Bean
    public DiscountPolicy DiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
