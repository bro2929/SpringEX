package org.hj.mapper;

import java.util.ArrayList;	// ArrayList<LoginVO>를 사용하기 위해 import

import org.hj.model.LoginVO;

public interface LoginMapper {// 추상메서드

	public void memreg(LoginVO member);
	
	public LoginVO login(LoginVO member);	// 리턴값이 한건이라 LoginVO에 저장 가능
	
	public ArrayList<LoginVO> memlist();	// 리턴값이 여러건이라 배열 사용
	
	public LoginVO memDetail(LoginVO memberId);	// 메서드 선언
	//public LoginVO memDetail(String memberId); 도 가능
	
	public void memModify(LoginVO login);
	
	public void memRemove(LoginVO login);
}
