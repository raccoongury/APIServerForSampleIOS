package com.raccongury.server;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raccongury.server.dao.MemoDAO;


@Controller
public class HomeController {
	//데이터베이스 접속 정보 테스트
	@Autowired
	private MemoDAO memoDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Map<String, Object>map = 
				new HashMap<String, Object>();
		map.put("title", "제목 테스트");
		map.put("contents", "내용 테스트");
		map.put("regdate", "2018-11-19");
		map.put("image_path", "image.png");
		
		
		System.out.println(memoDao.memoinsert(map));
		return "home";
	}
	
}