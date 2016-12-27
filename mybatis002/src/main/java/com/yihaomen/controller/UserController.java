package com.yihaomen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yihaomen.mybatis.model.Article;

import com.yihaomen.mybatis.inter.IUserOperation;

@Controller
@RequestMapping("/article")
public class UserController {
	
	@Autowired
	IUserOperation userMapper;

	@RequestMapping("/list")
	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) {
		List<Article> articles = userMapper.getUserArticles(1);
		
		Double temp=(Double) httpSession.getAttribute("redis-se");
		if(null==temp){
			httpSession.setAttribute("redis-se", Math.random());
			System.out.println("first set session......");
		}else {
			System.out.println(temp);
		}
		
		ModelAndView mav = new ModelAndView("list");
		for (Article article : articles) {
			System.out.println(article.getContent() + "--" + article.getTitle());

		}
		System.out.println("runing in list...");
		mav.addObject("articles", articles);
		return mav;
	}
}