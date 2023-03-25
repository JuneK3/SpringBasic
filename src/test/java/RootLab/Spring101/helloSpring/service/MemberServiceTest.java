package RootLab.Spring101.helloSpring.service;

import RootLab.Spring101.helloSpring.domain.Member;
import RootLab.Spring101.helloSpring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

	//	MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//	MemberService memberService = new MemberService(memberRepository);
	MemoryMemberRepository memberRepository;
	MemberService memberService;

	@BeforeEach
	public void BeforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@AfterEach
	public void AfterEach() {
		memberRepository.clearStore();
	}

	@Test
	void join() {
		//given
		Member member = new Member();
		member.setName("spring");

		//when
		Long saveId = memberService.join(member);

		//then
		Member foundMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(foundMember.getName());
	}

	@Test
	public void duplicateMember() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");

		//when
		memberService.join(member1);

		//then
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
}