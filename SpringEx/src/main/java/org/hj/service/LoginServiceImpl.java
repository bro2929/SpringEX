package org.hj.service;

import java.util.ArrayList;

import org.hj.mapper.LoginMapper;
import org.hj.model.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginMapper lm;
	
	public void memreg(LoginVO member) {// 구현메서드
		lm.memreg(member);//클래스.메소드(매개변수)
	};
	
	public LoginVO login (LoginVO member) {
		System.out.println("service="+member);
		System.out.println("service return="+lm.login(member));
		return lm.login(member);
	}
	
	public ArrayList<LoginVO> memlist() {
		return lm.memlist();
	};
	
	public LoginVO memDetail(LoginVO memberId) {
		return lm.memDetail(memberId);	// 메서드 호출
	};
	
	public void memModify(LoginVO login) {
		lm.memModify(login);
	};
	
	public void memRemove(LoginVO login) {
		lm.memRemove(login);
	};
	
}
