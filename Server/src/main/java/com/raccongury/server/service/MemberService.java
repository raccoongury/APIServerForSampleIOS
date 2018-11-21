package com.raccongury.server.service;

import javax.servlet.http.HttpServletRequest;

import com.raccongury.server.domain.Member;

public interface MemberService {
	//로그인을 처리하기 위한 메소드
	public Member login(HttpServletRequest request);
}
