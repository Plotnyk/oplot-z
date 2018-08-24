package spring_rest.controller;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;

import spring_rest.config.AppConfig;

import javax.servlet.ServletContext;

import java.util.Arrays;

import static org.hamcrest.collection.IsIn.isIn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class SitiTest {
    static {
        System.out.println(System.getProperty("user.dir"));
    }
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(
                this.wac).build();
    }

    //Проверка на запуск контекста
    @Test
    public void givenWac_whenServletContest_thenItProvidesGreetController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("applicationController"));
    }

    //Проверка на наличие стартовой страницы
    @Test
    @Ignore
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("index"));
    }

    //проверка количества элементов в масиве
    @Test
    public void testGetCountArraySuccses() throws Exception {
        this.mockMvc.perform(get("/all")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

    //проверка соответствие значений в масиве
    @Test
    public void testFindCitiesSuccess() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/all")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.*", contains("Odessa", "Kiyv")))
        .andDo(print()).andReturn();
    }

}
