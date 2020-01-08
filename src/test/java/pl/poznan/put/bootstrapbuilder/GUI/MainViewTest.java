package pl.poznan.put.bootstrapbuilder.GUI;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.poznan.put.bootstrapbuilder.BootstrapBuilderAbstractTest;
import pl.poznan.put.bootstrapbuilder.logic.BootstrapBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MainViewTest extends BootstrapBuilderAbstractTest {
    private MainView mainView;


    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        mainView = new MainView();
    }

    @Test
    public void testGetRequest() throws Exception {
        String uri = "/bootstrap?header=true&footer=false&title=Title&type=Type&description=Desc&image=Image&headerVersion=static&seoVersion=basic";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        mainView.getIsHeaderCheckBox().setValue(true);
        mainView.getIsFooterCheckBox().setValue(false);
        mainView.getTitleTextField().setValue("Title");
        mainView.getTypeTextField().setValue("Type");
        mainView.getDescriptionTextArea().setValue("Desc");
        mainView.getImageTextField().setValue("Image");
        mainView.getHeaderVersionListBox().setValue("static");
        mainView.getSeoVersionListBox().setValue("basic");
        mainView.buttonClickHandle();
        assertEquals(mainView.getResult().getValue(), content);
    }


    @Test
    void testTypeTextField() {
        assertEquals(mainView.getTypeTextField().getLabel(), "Type");
        mainView.getTypeTextField().setLabel("testLabel");
        assertEquals(mainView.getTypeTextField().getLabel(), "testLabel");
    }

    @Test
    void testSeoListBox() {
        assertEquals(mainView.getSeoVersionListBox().getValue(), "basic");
        mainView.getSeoVersionListBox().setValue("twitter");
        assertEquals(mainView.getSeoVersionListBox().getValue(), "twitter");

        assertThrows(IllegalArgumentException.class, () -> {
            mainView.getSeoVersionListBox().setValue("asgas");
        });
    }

    @Test
    void testGetButtonClick() {
        assertEquals(mainView.getResult().getValue(), "");
        mainView.buttonClickHandle();
        assertNotEquals(mainView.getResult().getValue(), "");
    }

    @Test
    void testHeaderVersionListBox() {
        assertFalse(mainView.getHeaderVersionListBox().isEnabled());

        assertThrows(IllegalArgumentException.class, () -> {
            mainView.getHeaderVersionListBox().setValue("asgas");
        });
    }
}