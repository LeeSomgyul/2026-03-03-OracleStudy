package com.sist.vo;
/*
 * EMPNO     NOT NULL NUMBER(5)     
ENAME     NOT NULL VARCHAR2(30)  
GENDER             CHAR(1)       
ADDRESS            VARCHAR2(50)  
AGE                NUMBER(3)     
POSITION           VARCHAR2(20)  
LOCATION           VARCHAR2(30)  
SALARY             NUMBER(10,2)  
PHONE              VARCHAR2(20)  
INTRO              VARCHAR2(100) 
DEPTNO    NOT NULL NUMBER(2)     
HIRE_DATE          DATE   */

import java.util.*;
import lombok.Data;

@Data
public class SawonVO {
	private int empno, age, deptno;
	private String ename, gender, address, position, location, phone, intro, dbday, pay;
	private Date hire_date;
	
	
}
