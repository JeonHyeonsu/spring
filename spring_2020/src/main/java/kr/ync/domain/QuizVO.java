package kr.ync.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class QuizVO {
	private int quiz_idx;
	private String question;
	private String answer;
	private String example1;
	private String example2;
	private String example3;
	private String id;
	private Date reg_date;
	private int type_idx;
	private Date updatedate;
  
}
