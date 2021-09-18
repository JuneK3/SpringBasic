package RootLab.Spring101.helloSpring;

import RootLab.Spring101.helloSpring.repository.MemberRepository;
import RootLab.Spring101.helloSpring.repository.MemoryMemberRepository;
import RootLab.Spring101.helloSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository(){
		return new MemoryMemberRepository();
	}
}
