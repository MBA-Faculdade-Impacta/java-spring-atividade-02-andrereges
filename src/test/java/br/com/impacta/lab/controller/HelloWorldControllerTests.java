package br.com.impacta.lab.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import br.com.impacta.lab.JavaSpringTemplateApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
		  classes = JavaSpringTemplateApplication.class)
@AutoConfigureMockMvc
public class HelloWorldControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void a1_helloWorldTest() throws Exception {
		RequestBuilder request = get("/atividades/hello").queryParam("nome", "Felipe")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("Hello world Felipe !".toUpperCase(), response.toUpperCase());
		
	}
	
	@Test
	public void a2_helloWorldTest() throws Exception {
		RequestBuilder request = get("/atividades/hello").queryParam("nome", "TESTE")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("Hello world TESTE !".toUpperCase(), response.toUpperCase());
		
	}

	@Test
	public void a2_ConditionalAgeLess17Test() throws Exception {
		RequestBuilder request = get("/atividades/conditional").queryParam("age", "15")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("Você possui menos de 18 anos".toUpperCase(), response.toUpperCase());
		
	}

	@Test
	public void a2_ConditionalAgeMore18Test() throws Exception {
		RequestBuilder request = get("/atividades/conditional").queryParam("age", "20")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("Você possui 18 anos ou mais".toUpperCase(), response.toUpperCase());
		
	}

	@Test
	public void a2_RepetitionTest() throws Exception {
		RequestBuilder request = get("/atividades/repetition").queryParam("number", "10")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("12345678910".toUpperCase(), response.toUpperCase());
		
	}
	
}
