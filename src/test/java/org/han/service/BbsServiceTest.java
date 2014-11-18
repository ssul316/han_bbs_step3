package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.han.util.PageMaker;
import org.han.vo.BbsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/**/*-context.xml" })
public class BbsServiceTest {

	static Logger logger = Logger.getLogger(BbsService.class);
	
	@Inject
	BbsService service;
	
	@Inject
	BbsVO vo;
	
	@Inject
	PageMaker pm;
	
	@Test
	public void createTest(){
		vo.setTitle("명진아 디질래");
		vo.setUserid("han00");
		vo.setCont("몇대맞고 피똥쌀래");
		
		service.create(vo);
	}
	
	@Test
	public void listTest(){
		pm.setPage(1);
		List<BbsVO> list = service.list(pm);
		logger.info(list);
	}
	
	@Test
	public void readTest(){
		logger.info(service.read(585));
	}
	
	@Test
	public void deleteTest(){
		service.delete(544);
	}

}
