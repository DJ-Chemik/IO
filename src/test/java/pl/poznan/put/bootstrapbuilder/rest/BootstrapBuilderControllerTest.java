package pl.poznan.put.bootstrapbuilder.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.poznan.put.BootstrapBuilderAbstractTest;
import pl.poznan.put.bootstrapbuilder.logic.BootstrapBuilder;

import static org.junit.Assert.assertEquals;

/**
 * Basic test class for Controller
 *
 * @author Jan Śmiełowski
 */
public class BootstrapBuilderControllerTest extends BootstrapBuilderAbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Test for GET request
     *
     * @throws Exception when mvc encounters error
     */
    @Test
    public void testGetRequest() throws Exception {
        String uri = "/bootstrap?header=true&footer=true&title=Title&type=Type&description=desc&image=img.jpg&headerVersion=static&seoVersion=og";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        String expected = new BootstrapBuilder(true, true, "Title", "Type",
                "desc", "img.jpg", "static", "og").getBootstrap();
        assertEquals(expected, content);
    }

    /**
     * Test for POST request
     *
     * @throws Exception when mvc encounters error
     */
    @Test
    public void testPostRequest() throws Exception {
        BootstrapBuilder bootstrap = new BootstrapBuilder(true, true, "Title", "Type",
                "desc", "img.jpg", "static", "og");
        String json = super.mapToJson(bootstrap);

        String uri = "/bootstrap";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(bootstrap.getBootstrap(), content);
    }

}