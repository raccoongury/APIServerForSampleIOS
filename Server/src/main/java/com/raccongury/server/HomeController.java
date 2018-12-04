package com.raccongury.server;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	//@Autowired
	//private SqlSession sqlSession;
	
	//메모 데이터베이스 접속 정보 테스트
		@Autowired
		private SqlSession sqlSession;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//실행 시켜서 해시코드가 나오는지 확인
		/*
		System.out.println(
				"sqlSession:" + sqlSession.toString());
				*/
		
/*		//메모 해시코드 나오는지 확인
		System.out.println(sqlSession);
		*/
		
		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put("title", "메모입니다.");
		map.put("contents", "메모의 내용입니다.");
		map.put("regdate", "2018-11-11 12:00:00");
		map.put("image_path", "sample.png");
		
		/*
		System.out.println(
				sqlSession.insert("memo.memoinsert", map));
				*/
		
		
		//리스트 확인
		System.out.println(
				sqlSession.selectList("memo.memolist"));
				
		
		/*
		System.out.println(
				sqlSession.selectOne("memo.memodetail", 3).toString());
		*/
		
		/*
		//삭제 확인
		System.out.println(
				sqlSession.delete("memo.memodelete", 3));
				*/
		
		return "home";
	}
	
}