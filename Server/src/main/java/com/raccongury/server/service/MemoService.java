package com.raccongury.server.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

//사용자의 요청을 처리하기 위한 메소드의 모양을 선언
public interface MemoService {
	//전체 데이터 보기를 처리해주는 메소드
	public Map<String, Object> memolist(
			HttpServletRequest request);
	
	//상세보기를 위한 메소드
	public Map<String, Object> memodetail(
			HttpServletRequest request);
	
	//데이터 삭제를 위한 메소드
	public Map<String, Object> memodelete(
			HttpServletRequest request);
	
	//데이터 삽입를 위한 메소드
	//파일을 저장해야 하기 때문에 MultipartHttpServletRequest 사용
	public Map<String, Object> memoinsert(
			MultipartHttpServletRequest request);
	
	
}