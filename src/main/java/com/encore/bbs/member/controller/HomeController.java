package com.encore.bbs.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// 기본 페이지를 요청하는 메서드
	@GetMapping("/")
	public String index() {

		return "/index"; // templates 폴더에 있는 index.html 파일 찾아감. thymeleaf 때문
	}
}