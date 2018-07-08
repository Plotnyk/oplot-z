package mvc.rest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application-context.xml", "classpath*:mvc-config.xml"})
/*@ContextConfiguration(classes = {TestContext.class})*/
@WebAppConfiguration
public class CityResourceTest {
    private MockMvc mockMvc;

    @InjectMocks
    private CityResource todoServiceMock;

/*    @Autowired
    private WebApplicationContext webApplicationContext;*/

    @Before
    public void setUp() {
        /*todoServiceMock = new CityResource();*/
/*        Mockito.reset(todoServiceMock);


        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();*/


        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(todoServiceMock)
                .build();
    }

    @Test
    @Ignore
    public void findAll_TodosFound_ShouldReturnFoundTodoEntries() throws Exception {
        System.out.println("1");
        List<TestA> testAS = Arrays.asList(
        new TestA(0, "Den"),
        new TestA(1, "Kot"));
        System.out.println("2");

        when(todoServiceMock.findCities()).thenReturn(testAS);
        System.out.println("3");
        mockMvc.perform(get("/city/rest/getAllDBLogsJSON_A"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(0)))
                .andExpect(jsonPath("$[0].user", is("Den")))
                .andExpect(jsonPath("$[1].id", is(1)))
                .andExpect(jsonPath("$[1].user", is("Kot")));
        System.out.println("4");

        verify(todoServiceMock, times(1)).findCities();
        verifyNoMoreInteractions(todoServiceMock);
    }

}