package qna.svc;

import static qna.db.jdbcutil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qna.dao.qnaBoardDAO;
import qna.vo.qnaBoardbean;


public class qnaBoardModifyService {

	//글수정 작업요청 
	public boolean regisartiset(qnaBoardbean qnaboardbean) {
	boolean ismodifySuccess = false;
	

	Connection con = getconnection();
	

	qnaBoardDAO board=qnaBoardDAO.getinstance();
	
	board.setCon(con);
	
	int passcheck = board.check(qnaboardbean);
	
	
	if(passcheck>0) {
		
		board.modifyArticle(qnaboardbean);
		commit(con);
		ismodifySuccess=true;
		
	}else {
		System.out.println("비밀번호가 다릅니다.");
		rollback(con);
		
	}
	

	close(con); 

	return ismodifySuccess;
	
	

		
		
		
		
		
	}
	
	
	
	
}
