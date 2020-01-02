package pl.poznan.put.bootstrapbuilder.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootstrapBuilderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testBasicConstruction() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "Title", "type",
                "description", "image.jpg", "static", "og");
        assertEquals("Title", bootstrapBuilder.getTitle());
        assertEquals("static", bootstrapBuilder.isHeader() ? bootstrapBuilder.getHeaderVersion() : null);
    }

    @Test
    void testBuilderConstruction() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder.Builder()
                .header(true)
                .footer(true)
                .title("Title")
                .type("type")
                .description("description")
                .image("image.jpg")
                .headerVersion("fixed")
                .seoVersion("twitter")
                .build();
        assertEquals("Title", bootstrapBuilder.getTitle());
        assertEquals("fixed", bootstrapBuilder.isHeader() ? bootstrapBuilder.getHeaderVersion() : null);
    }

}