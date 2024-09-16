package book.vo;


public class CarBean {
	public enum CAR_TYPE{
		경차(0,"경차"),
		소형(1,"소형"),
		중형(2,"중형"),
		준대형(3,"준대형"),
		대형(4,"대형"),
		승합(5,"승합"),
		SUVㅣRV(6,"SUV/RV"),
		전기차(7,"전기차"),
		수입차(8,"수입차");
		
		private final int value;
		private final String StringValue;
		
		
		
		private CAR_TYPE(int v, String y) {
			value = v;
			StringValue=y;
		}
		
		public int getInt() {
			return value;
		}
		public String getString() {
			return StringValue;
		}
	}
	
	public enum FUNCTION{
		전륜(0,"전륜"),
		후륜(1,"후륜"),
		사륜구동(2,"사륜구동");
	
		private final int value;
		private final String StringValue;
		private FUNCTION(int v,String y) {
			value = v;
			StringValue=y;
		}
		
		public int getInt() {
			return value;
		}
		public String getString() {
			return StringValue;
		}
	}
	
	public enum LICENSE_TYPE{
		제1종대형(0,"제1종대형"),
		제1종보통(1,"제1종보통"),
		제1종소형(2,"제1종소형"),
		제1종특수(3,"제1종특수"),
		제2종보통(4,"제2종보통"),
		제2종소형(5,"제2종소형"),
		제2종원동기(6,"제2종원동기");
	
		private final int value;
		private final String StringValue;
		private LICENSE_TYPE(int v,String y) {
			value = v;
			StringValue=y;
		}
		
		public int getInt() {
			return value;
		}		
		public String getString() {
			return StringValue;
		}
	}
	
	public enum OIL_TYPE{
		가솔린(0,"가솔린"),
		경유(1,"경유"),
		LPG(2,"LPG"),
		CNG(3,"CNG"),
		전기(4,"전기"),
		하이브리드(5,"하이브리드");
	
		private final int value;
		private final String StringValue;
		private OIL_TYPE(int v,String y) {
			value = v;
			StringValue=y;
		}
		
		public int getInt() {
			return value;
		}		
		public String getString() {
			return StringValue;
		}
	}
	
	private int car_id;
	private boolean car_is_rent;
	private String car_maker,car_num;
	private String car_name;
	private CAR_TYPE car_type; // 타입을 int값으로 설정해서 정해놔야 함. Enum 값으로 설정해두었음.
	private int car_people_max;
	private int car_people_possible;
	private int car_year;
	private OIL_TYPE car_oil;
	private boolean car_is_auto;
	private LICENSE_TYPE car_license_type;
	private int car_license_year;

	private int car_need_year;
	private int car_cc;
	private int car_price_normal;
	private int car_price_sale;
	private FUNCTION car_function;
	private int car_trunk;
	private String car_color;
	private boolean car_is_navi;
	private boolean car_is_pet;
	private boolean car_is_open;
	private boolean car_is_smoke;
	
	
	
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public boolean isCar_is_rent() {
		return car_is_rent;
	}
	

	
	
	public void setCar_is_rent(boolean car_is_rent) {
		this.car_is_rent = car_is_rent;
	}
	public String getCar_maker() {
		return car_maker;
	}
	public void setCar_maker(String car_maker) {
		this.car_maker = car_maker;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public CAR_TYPE getCar_type() {
		return car_type;
	}
	public void setCar_type(int car_type) {
		this.car_type = CAR_TYPE.values()[car_type];
	}
	public int getCar_people_max() {
		return car_people_max;
	}
	public void setCar_people_max(int car_people_max) {
		this.car_people_max = car_people_max;
	}
	public int getCar_people_possible() {
		return car_people_possible;
	}
	public void setCar_people_possible(int car_people_possible) {
		this.car_people_possible = car_people_possible;
	}
	public int getCar_year() {
		return car_year;
	}
	public void setCar_year(int car_year) {
		this.car_year = car_year;
	}
	public OIL_TYPE getCar_oil() {
		return car_oil;
	}
	public void setCar_oil(int car_oil) {
		this.car_oil = OIL_TYPE.values()[car_oil];
	}
	public boolean isCar_is_auto() {
		return car_is_auto;
	}
	public void setCar_is_auto(boolean car_is_auto) {
		this.car_is_auto = car_is_auto;
	}
	public LICENSE_TYPE getCar_license_type() {
		return car_license_type;
	}
	public void setCar_license_type(int car_license_type) {
		this.car_license_type = LICENSE_TYPE.values()[car_license_type];
	}
	public int getCar_license_year() {
		return car_license_year;
	}
	public void setCar_license_year(int car_license_year) {
		this.car_license_year = car_license_year;
	}
	public int getCar_need_year() {
		return car_need_year;
	}
	public void setCar_need_year(int car_need_year) {
		this.car_need_year = car_need_year;
	}
	public int getCar_cc() {
		return car_cc;
	}
	public void setCar_cc(int car_cc) {
		this.car_cc = car_cc;
	}
	public int getCar_price_normal() {
		return car_price_normal;
	}
	public void setCar_price_normal(int car_price_normal) {
		this.car_price_normal = car_price_normal;
	}
	public int getCar_price_sale() {
		return car_price_sale;
	}
	public void setCar_price_sale(int car_price_sale) {
		this.car_price_sale = car_price_sale;
	}
	public FUNCTION getCar_function() {
		return car_function;
	}
	public void setCar_function(int car_function) {
		this.car_function = FUNCTION.values()[car_function];
	}
	public int getCar_trunk() {
		return car_trunk;
	}
	public void setCar_trunk(int car_trunk) {
		this.car_trunk = car_trunk;
	}
	public String getCar_color() {
		return car_color;
	}
	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}
	public boolean isCar_is_navi() {
		return car_is_navi;
	}
	public void setCar_is_navi(boolean car_is_navi) {
		this.car_is_navi = car_is_navi;
	}
	public boolean isCar_is_pet() {
		return car_is_pet;
	}
	public void setCar_is_pet(boolean car_is_pet) {
		this.car_is_pet = car_is_pet;
	}
	public boolean isCar_is_open() {
		return car_is_open;
	}
	public void setCar_is_open(boolean car_is_open) {
		this.car_is_open = car_is_open;
	}
	public boolean isCar_is_smoke() {
		return car_is_smoke;
	}
	public void setCar_is_smoke(boolean car_is_smoke) {
		this.car_is_smoke = car_is_smoke;
	}
	public String getCar_num() {
		return car_num;
	}
	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}
	
}
