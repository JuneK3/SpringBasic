package RootLab.Spring101.helloSpring;

import RootLab.Spring101.helloSpring.repository.JdbcMemberRepository;
import RootLab.Spring101.helloSpring.repository.MemberRepository;
import RootLab.Spring101.helloSpring.repository.MemoryMemberRepository;
import RootLab.Spring101.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
}
