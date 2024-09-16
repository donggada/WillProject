select * from member;

desc book;
desc member;
desc faqboard;

drop table member;

show tables;

CREATE TABLE `member` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `member_id` varchar(45) NOT NULL,
  `member_pass` varchar(45) DEFAULT NULL,
  `member_name` varchar(45) DEFAULT NULL,
  `member_age` varchar(45) DEFAULT NULL,
  `member_gender` varchar(45) DEFAULT NULL,
  `member_tel` varchar(45) DEFAULT NULL,
  `member_adress` varchar(100) DEFAULT NULL,
  `member_email` varchar(45) DEFAULT NULL,
  `member_license` varchar(45) DEFAULT NULL,
  `member_smoke` varchar(45) DEFAULT NULL,
  `member_pet` varchar(45) DEFAULT NULL,
  `member_baby` varchar(45) DEFAULT NULL,
  `member_grade` varchar(45) NOT NULL,
  PRIMARY KEY (`idx`,`member_id`)
);


CREATE TABLE book(
	book_num INT PRIMARY KEY AUTO_INCREMENT,
	member_id VARCHAR(45) NOT NULL,
	non_member_num INT NOT NULL,
	book_date date NOT NULL,
	pickup_date date NOT NULL,
	end_date date NOT NULL,
	car_id VARCHAR(20) NOT NULL,
	book_price INT NOT NULL,
	insurance INT NOT NULL,
	book_state INT NOT NULL
);

CREATE TABLE review(
	review_num INT PRIMARY KEY AUTO_INCREMENT,
	book_num INT UNIQUE NOT NULL,
	member_id VARCHAR(20) NOT NULL,
	car_id VARCHAR(20) NOT NULL,
	pickup_date VARCHAR(20) NOT NULL,
	end_date VARCHAR(20) NOT NULL,
	review_subject VARCHAR(50) NOT NULL,
	review_content VARCHAR(1000) NOT NULL,
	review_file VARCHAR(5000) NOT NULL,
	review_readcount INT NOT NULL,
	review_recocount INT NOT NULL,
	review_date DATE NOT NULL,
	review_pass INT NOT NULL
);


