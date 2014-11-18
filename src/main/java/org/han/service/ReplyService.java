package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.han.mapper.ReplyMapper;
import org.han.vo.ReplyVO;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	
	@Inject
	ReplyMapper mapper;
	
	public List<ReplyVO> list(ReplyVO vo){
		return mapper.list(vo.getBno());
	}
	
	public List<ReplyVO> create(ReplyVO vo){
		mapper.create(vo);
		return mapper.list(vo.getBno());
	}
	
	public List<ReplyVO> delete(ReplyVO vo){
		mapper.delete(vo);
		return mapper.list(vo.getBno());
	}
	
	public List<ReplyVO> update(ReplyVO vo){
		mapper.update(vo);
		return mapper.list(vo.getBno());
	}
}
