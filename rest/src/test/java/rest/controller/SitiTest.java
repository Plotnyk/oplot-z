package rest.controller;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import rest.config.JerseyConfig;
import javax.ws.rs.core.Application;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;


public class SitiTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    static {
        System.out.println(System.getProperty("user.dir"));
    }

    @Before
    public void setup() throws Exception {

    }


    @Test
    @Ignore
    public void testFindCitiesSuccess() {
/*        List<Map<String, String>> cities = target("places").request().get(List.class);
        assertNotNull(cities);
        assertEquals(cities.size(), 1);

        Map<String, String> city = cities.get(0);
        assertEquals(city.get("name"), "Odessa");*/
    }

   /* //Проверка на наличие стартовой страницы
    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("index"));
    }

    //проверка количества элементов в масиве
    @Test
    @Ignore
    public void testGetCountArraySuccses() throws Exception {
        this.mockMvc.perform(get("/api/places")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

    //проверка соответствие значений в масиве
    @Test
    @Ignore
    public void testFindCitiesSuccess() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/api/places")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.*", contains("Odessa", "Kiyv")))
        .andDo(print()).andReturn();
    }*/


}
