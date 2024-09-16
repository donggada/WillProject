package book.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class BookBean {

//	
//	| book_num       | int(11)     | NO   | PRI | NULL    |       |
//	| member_id      | varchar(45) | YES  |     | NULL    |       |
//	| non_member_num | int(11)     | YES  |     | NULL    |       |
//	| book_date      | date        | NO   |     | NULL    |       |
//	| pickup_date    | date        | NO   |     | NULL    |       |
//	| return_date    | date        | NO   |     | NULL    |       |
//	| car_id         | varchar(10) | NO   |     | NULL    |       |
//	| book_price     | int(11)     | NO   |     | NULL    |       |
//	| insurance      | int(11)     | NO   |     | NULL    |       |
//	| book_state     | int(11)     | NO   |     | NULL    |

	
	
	
	private int book_num;
	private int book_price;
	private int insurance;
	private int book_state;
	
	private int non_member_num;
	
	private Date book_date;
	private Date pickup_date;
	private Date end_date;
	
	private String member_id;
	private String car_id;
	
	
	private Timestamp book_date2;
	
	
	
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	private int sum;
	
	
	
	
	
	
	public Timestamp getBook_date2() {
		return book_date2;
	}
	public void setBook_date2(Timestamp book_date2) {
		this.book_date2 = book_date2;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getInsurance() {
		return insurance;
	}
	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}
	public int getBook_state() {
		return book_state;
	}
	public void setBook_state(int book_state) {
		this.book_state = book_state;
	}
	public int getNon_member_num() {
		return non_member_num;
	}
	public void setNon_member_num(int non_member_num) {
		this.non_member_num = non_member_num;
	}
	public Date getBook_date() {
		return book_date;
	}
	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}
	public Date getPickup_date() {
		return pickup_date;
	}
	public void setPickup_date(Date pickup_date) {
		this.pickup_date = pickup_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	
	
	
	
	
	
}

