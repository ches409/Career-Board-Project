package com.project.controller;



import com.project.model.PostDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.PostDao;
import com.project.model.ReplyDao;
import com.project.model.UserDO;
import com.project.model.UserSO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class ModelController {
	
	@Autowired
	private UserSO userSO;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@GetMapping("/changePasswd")	 
	public String changePasswdHandler() {
		return "changePasswd";
	}
	
	@PostMapping("/changePasswdProcess")
	public String changePasswdProcessHandler() {
		return "main/main";
	}
	
	@GetMapping("/postForm")	 
	public String postFormHandler(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if(session != null) {
			String user_id = (String)session.getAttribute("user_id");
			model.addAttribute("postCount", postDao.countPost(user_id));	
			model.addAttribute("replyCount", replyDao.countReply(user_id));
		}
		return "postForm";
	}
	
	@PostMapping("/postFormProcess")
	public String postFormProcessHandler(PostDO postDO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			String user_id = (String)session.getAttribute("user_id");
			postDao.insertPost(postDO, user_id);
		}
		return "main";
	}
	
//	@GetMapping("/main")
//	public String mainHandler(Model model) {
////		List<PostDO> postList = postService.getAllPost();
//		return "main/main";
//	}
	
//	@GetMapping("/detail")
//	public String detailPageView() {
//		return "detailPage";
//	}
	
	
	
}
