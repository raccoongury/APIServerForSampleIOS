package com.raccongury.server;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raccongury.server.service.MemoService;

@RestController
//위의 어노테이션을 사용할 때는 spring 버전이 4.0이상인지 확인
//jackson-databind 라이브러리가 포함되어 있는지 확인

public class MemoRestController {
	//실제 서비스되는 프로젝트의 경우에는 여러개의 서비스 객체가
	//포함되는 경우가 많습니다.
	@Autowired
	private MemoService memoService;
	

//	@RequestMapping(value="url", method=RequestMethod.전송방식)
//	public Map<String, Object> 메소드이름(HttpServeletRequest request){
//		return memoService.memolist(request);
//	}
	@RequestMapping(value="memo/memolist", method=RequestMethod.GET)
	public Map<String,Object> 메소드이름(HttpServletRequest request){
		return memoService.memolist(request);
	}
	
	@RequestMapping(value="memo/memodetail", 
			method=RequestMethod.GET)
	public Map<String,Object> memodetail(HttpServletRequest request){
		return memoService.memodetail(request);
	}
}


