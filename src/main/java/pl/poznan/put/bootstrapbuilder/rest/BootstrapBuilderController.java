package pl.poznan.put.bootstrapbuilder.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poznan.put.bootstrapbuilder.logic.BootstrapBuilder;

/**
 * Main controller for dispatching REST requests
 *
 * @author Jan Śmiełowski
 * @author Mikołaj Szymczak
 * @version 2.0
 */
@RestController
public class BootstrapBuilderController {

    /**
     * GET request mapping method
     *
     * @param header specifier for header
     * @param footer specifier for footer
     * @param title specifier for title
     * @param type specifier for type
     * @param description specifier for description
     * @param image specifier for image
     * @param headerVersion specifier for header version
     * @param seoVersion specifier for SEO version
     * @return Bootstrap code, formatted by params
     */
    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET, produces = "application/json")
    public static String getViaParams(@RequestParam(value = "header") boolean header, @RequestParam(value = "footer") boolean footer,
                                      @RequestParam(value = "title") String title,@RequestParam(value = "type") String type,
                                      @RequestParam(value = "desc") String description, @RequestParam(value = "image") String image,
                                      @RequestParam(value = "headerversion") String headerVersion, @RequestParam(value = "seoversion") String seoVersion) {
        BootstrapBuilder bootstrap = new BootstrapBuilder.Builder().header(header).footer(footer).title(title).type(type).description(description)
                .image(image).headerVersion(headerVersion).seoVersion(seoVersion).build();
        return bootstrap.getBootstrap();
    }

    /**
     * POST request mapping method
     *
     * @param bootstrap instance of BootstrapBuilder from JSON
     * @return Bootstrap code, formatted by params
     */
    @RequestMapping(value = "/bootstrap", method = RequestMethod.POST, produces = "application/json")
    public static String getViaBody(@RequestBody BootstrapBuilder bootstrap) {
        return bootstrap.getBootstrap();
    }

}
