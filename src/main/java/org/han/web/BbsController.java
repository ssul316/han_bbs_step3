package org.han.web;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.util.PageMaker;
import org.han.vo.BbsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/bbs/*")
public class BbsController {
	
	@Inject
	BbsVO vo;
	
	@Inject
	BbsService service;
	
	@RequestMapping("/cboard")
	public void cboard(){}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute BbsVO vo){
		service.create(vo);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public void list(@ModelAttribute PageMaker pm, Model model){
		model.addAttribute("list", service.list(pm));
	}
	
	@RequestMapping("/read")
	public void read(@RequestParam(value="bno", defaultValue="") int bno, Model model){
		model.addAttribute("vo", service.read(bno));
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="bno", defaultValue="") int bno){
		service.delete(bno);
		return "redirect:list";
	}
	
	@RequestMapping("/uboard")
	public void uboard(@RequestParam(value="bno", defaultValue="") int bno, Model model){
		model.addAttribute("vo", service.read(bno));
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute BbsVO vo){
		service.update(vo);
		return "redirect:read?bno="+vo.getBno();
	}
}
