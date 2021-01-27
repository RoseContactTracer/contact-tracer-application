package edu.rosehulman.covidtracer.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.hamcrest.Matchers;

import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.service.PositiveCaseService;

public class PositiveCaseControllerTest {
	
	@Mock
	private PositiveCaseService service;
	
	@InjectMocks
	private PositiveCaseController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testGetAllPositiveCases() throws Exception {
		List<PositiveCase> cases = new ArrayList<PositiveCase>();
		cases.add(new PositiveCase());
		cases.add(new PositiveCase());
		
		Mockito.when(service.getAllPositiveCases(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn((List<PositiveCase>) cases);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/positive-case"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("/positive-case"))
			.andExpect(MockMvcResultMatchers.model().attribute("positiveCase", Matchers.hasSize(2)));
	}

}
