package org.han.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/**/*-context.xml"})
public class ReplyControllerTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    private static Logger logger = LoggerFactory.getLogger("ReplyControllerTest");

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
	@Test
	public void listTest() throws Exception{
		logger.info(this.mockMvc.toString());
		MvcResult result = mockMvc.perform(get("/bbs/reply/list"))
		.andExpect(status().isOk())
		.andReturn();
		
		logger.info(result.getModelAndView().getModelMap().get("list").toString());
	}
	

	@Test
	public void createTest() throws Exception{
		logger.info(this.mockMvc.toString());
		MvcResult result = mockMvc.perform(get("/bbs/create")
				.param("title", "명진아 시끄")
				.param("userid", "han00")
				.param("cont", "코딩을 입으로 하지말고 손꾸락으로 하라고~~~"))
		.andReturn();
		
		logger.info(result.getModelAndView().getViewName());
	}
	
	@Test
	public void readTest() throws Exception{
		logger.info(this.mockMvc.toString());
		MvcResult result = mockMvc.perform(get("/bbs/read")
				.param("bno", "585"))
		.andExpect(status().isOk())
		.andReturn();
		
		logger.info(result.getModelAndView().getModelMap().get("vo").toString());
	}

	/*
	@Test
	public void test() throws Exception{
		logger.info(this.mockMvc.toString());
		MvcResult result = mockMvc.perform(get("/member/doA"))
		// c,u,d할땐 빼도 됨
		.andExpect(status().isOk())
		.andReturn();
		
		logger.info(result.getModelAndView().getViewName());
	}
	*/
}
