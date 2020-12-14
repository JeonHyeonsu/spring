package kr.ync.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class QuizMemberVO {

	private String id;
	private String pwd;
	private String username;
	private int point;
	private String email;
	private String profile_img;
	private String profile;

	private Date reg_date;
	private List<AuthVO> auth;
}
