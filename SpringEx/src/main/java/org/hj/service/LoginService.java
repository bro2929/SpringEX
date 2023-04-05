package org.hj.service;

import java.util.ArrayList;

import org.hj.model.LoginVO;

public interface LoginService {// 추상메서드(설계 목적)
	// 회원가입
	public void memreg(LoginVO member);		
	// 로그인
	public LoginVO login(LoginVO member);
	// 관리자 리스트
	public ArrayList<LoginVO> memlist();					
	// 회원정보 상세
	public LoginVO memDetail(LoginVO memberId);	// 메서드 선언(retrun이 있는곳)
	// 회원정보 수정
	public void memModify(LoginVO login);
	// 회원정보 삭제
	public void memRemove(LoginVO login);
		
	
	// Service 단계에서 if문 등으로 가공을 한 후 
	// SQL로 넘겨주는 것
}
