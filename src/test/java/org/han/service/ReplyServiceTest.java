package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.han.vo.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/**/*-context.xml" })
public class ReplyServiceTest {
	
	static Logger logger = Logger.getLogger(ReplyService.class);

	@Inject
	ReplyService service;
	
	@Inject
	ReplyVO vo;
	
	@Test
	public void updateTest(){
		vo.setBno(603);
		vo.setCont("µÇ³ª¿ä??");
		vo.setRno(145);

		logger.info(service.update(vo));
	}
	
	

}
