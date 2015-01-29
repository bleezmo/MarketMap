package com.bleezmo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MarketMapApplication.class)
@WebAppConfiguration
@ComponentScan
public class MarketMapApplicationTests {
	ConfigurableApplicationContext context = null;
	@Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
	@Before
	public void setup() throws Exception{
		context = new AnnotationConfigApplicationContext(MarketMapApplication.class);
	}
	@After
	public void tearDown() throws Exception{
		context.close();
	}
	@Test
	public void test() {
		MessageComponent comp = context.getBean(MessageComponent.class);
		Assert.assertEquals(comp.processMessage("blah blah blah"),new EmailService().processMessage("blah blah blah"));
	}

}
