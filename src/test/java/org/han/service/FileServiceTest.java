package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.han.service.BbsService;
import org.han.vo.BbsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/**/*-context.xml" })
public class FileServiceTest {

static Logger logger = Logger.getLogger(FileService.class);

	@Inject
	BbsService service;
	
	@Inject
	BbsVO vo;

}