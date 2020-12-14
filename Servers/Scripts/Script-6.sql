select SEQ_quiz_IDX.nextval from dual;
 
 alter sequence SEQ_quiz_IDX increment by -33186 minvalue 0;
 
 select SEQ_quiz_IDX.nextval from dual;
 
 alter sequence SEQ_quiz_IDX increment by 1 minvalue 0;