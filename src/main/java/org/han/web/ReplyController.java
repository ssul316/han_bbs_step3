package org.han.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.han.service.ReplyService;
import org.han.vo.ReplyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bbs/reply/*")
public class ReplyController {
	
	@Inject
	ReplyVO vo;
	
	@Inject
	ReplyService service;
	
	@RequestMapping("/list")
	public @ResponseBody List<ReplyVO> list(@ModelAttribute ReplyVO vo){
		return service.list(vo);
	}
	
	@RequestMapping("/create")
	public @ResponseBody List<ReplyVO> create(@ModelAttribute ReplyVO vo){
		return service.create(vo);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody List<ReplyVO> delete(@ModelAttribute ReplyVO vo){
		return service.delete(vo);
	}
	
	@RequestMapping("/update")
	public @ResponseBody List<ReplyVO> update(@ModelAttribute ReplyVO vo){
		return service.update(vo);
	}
}
