package com.lec.ch02;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lec.ch02.ex1_cal.Service;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleConfigurationTests {
	
	@Autowired
	private Service service;

	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(service);
	}
	
}
