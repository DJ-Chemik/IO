package pl.poznan.put.bootstrapbuilder.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic test class for BootstrapBuilder
 *
 * @author Jan Śmiełowski
 * @version 1.0
 */
class BootstrapBuilderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test for BootstrapBuilder constructing via basic constructor with parameters
     */
    @Test
    void testBasicConstruction() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "Title", "type",
                "description", "image.jpg", "static", "og");
        assertEquals("Title", bootstrapBuilder.getTitle());
        assertEquals("static", bootstrapBuilder.isHeader() ? bootstrapBuilder.getHeaderVersion() : null);
    }

    /**
     * Test for BootstrapBuilder constructing via static Builder
     */
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

    /**
     * Test for some setters appropriate working
     */
    @Test
    void testSomeSetters() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "Title", "type",
                "description", "image.jpg", "static", "og");
        assertTrue(bootstrapBuilder.isFooter());
        assertEquals("description", bootstrapBuilder.getDescription());
        assertEquals("static", bootstrapBuilder.isHeader() ? bootstrapBuilder.getHeaderVersion() : null);

        bootstrapBuilder.setFooter(false);
        bootstrapBuilder.setDescription("modified");
        bootstrapBuilder.setHeaderVersion("fixed");

        assertFalse(bootstrapBuilder.isFooter());
        assertEquals("modified", bootstrapBuilder.getDescription());
        assertEquals("fixed", bootstrapBuilder.isHeader() ? bootstrapBuilder.getHeaderVersion() : null);
    }

    /**
     * Test for appropriate bootstrap generating (based on CharSequences inside)
     */
    @Test
    void testBootstrap() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "Title", "type",
                "description", "image.jpg", "static", "og");
        String bootstrap = bootstrapBuilder.getBootstrap();

        assertTrue(bootstrap.contains("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"));
        assertTrue(bootstrap.contains("<meta name=\"og:title\" content=\"Title\">"));
        assertTrue(bootstrap.contains("<nav class=\"navbar\">"));
    }

    /**
     * test if not wanted header appears in result string
     */
    @Test
    void testBootstrapHeaderFalse() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(false, true, "Title", "type",
                "description", "image.jpg", "static", "og");

        String bootstrap = bootstrapBuilder.getBootstrap();

        assertFalse(bootstrap.contains("<nav class=\"navbar\">"));
    }

    /**
     * Test for unknown header version (expecting static navbar)
     */
    @Test
    void testUnknownHeaderVersion() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "Title", "type",
                "description", "image.jpg", "invalid", "og");
        String bootstrap = bootstrapBuilder.getBootstrap();
        // expecting static navbar
        assertTrue(bootstrap.contains("<nav class=\"navbar\">"));
    }

    /**
     * Testing output html if footer should not be in the result
     */
    @Test
    void testBootstrapFooterFalse() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, false, "title", "type",
                "description", "image.jpg", "static", "og");
        String bootstrap = bootstrapBuilder.getBootstrap();
        assertFalse(bootstrap.contains("<footer class=\"footer\">"));
    }

    /**
     * Testing output html if footer should be in the result
     */
    @Test
    void testBootstrapFooterTrue() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "title", "type",
                "description", "image.jpg", "static", "og");
        String bootstrap = bootstrapBuilder.getBootstrap();
        assertTrue(bootstrap.contains("<footer class=\"footer\">"));
    }

    /**
     * Test for null header version (expecting error)
     */
    @Test
    void testNullHeaderVersion() {
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(true, true, "Title", "type",
                "description", "image.jpg", null, "og");
        // expecting error
        assertThrows(NullPointerException.class, bootstrapBuilder::getBootstrap);
    }

}