//package com.encore.bbs.member.handler;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//@ControllerAdvice // 모든 exception이 발생하면 이쪽으로 들어온다.
//@RestController // @RestController는 @Controller와 @ResponseBody를 합친 것
//// @RestController를 클래스에 적용하면 해당 클래스는 REST 엔드포인트를 처리하는 컨트롤러로 지정.
//public class GlobalExceptionHandler {
//
//	@ExceptionHandler(value = Exception.class) // 이쪽으로 들어왔을 때 어떤 exception을 받을 것인지 정의하는 어노테이션
//	public String handlerArgumentException(Exception e) {
//		return "<h1>" + "잘못된 경로입니다." + "</h1>"; // 바로 출력
//	}
//}
