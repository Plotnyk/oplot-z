package mvc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * {@link CityResource} is REST web-service that handles city-related requests
 * @author Plotnyk
 */
@Controller
@RequestMapping("/city/rest")
@EnableWebMvc
public class CityResource {

    /** look to mvc-config.xml for <mvc:message-converters>. It can produce 'pretty' json response. */
    @RequestMapping(value = "/getAllDBLogsJSON_A", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<TestA> findCities() {
        ArrayList<TestA> result = new ArrayList<>();
        TestA testA = new TestA(0, "Den");
        TestA testB = new TestA(1, "Kot");
        result.add(testA);
        result.add(testB);
        return result;
    }
}

class TestA {
    private int id;
    private String user;
    public TestA(int id, String user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestA testA = (TestA) o;
        return id == testA.id; /*&&
                Objects.equals(user, testA.user)*/
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + id;
        return result;
    }
}
