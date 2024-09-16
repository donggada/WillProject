package admin.svc;

import review.vo.ReviewBean;
import static member.db.JdbcUtill.*;

import java.sql.Connection;


import admin.dao.AdminDAO;

public class PopupPageUploadService {

	public boolean PoPUploade(ReviewBean reviewBean) {
	boolean	isUpload=false;
	int isUploadcount=0;
	
	Connection con=getConnection();
	
	AdminDAO adao=AdminDAO.adao;
	
	adao.setConnection(con);
	
	isUploadcount=adao.PoPUpload(reviewBean);
	
	if(isUploadcount>0) {
		commit(con);
		isUpload=true;
	}else {
		rollback(con);
	}
	
	close(con);
	
		return isUpload;
	}

}
