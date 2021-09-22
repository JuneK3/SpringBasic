package RootLab.Spring101.helloSpring;

import RootLab.Spring101.helloSpring.repository.*;
import RootLab.Spring101.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
}
