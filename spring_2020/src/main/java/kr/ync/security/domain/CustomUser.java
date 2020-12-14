package kr.ync.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.ync.domain.MemberVO;
import kr.ync.domain.QuizMemberVO;
import lombok.Getter;

@Getter
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private QuizMemberVO vo;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(QuizMemberVO vo) {

		super(vo.getId(), vo.getPwd(), vo.getAuth().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

		this.vo = vo;
	}
}
//로그인 한 애들 데이터 반환
