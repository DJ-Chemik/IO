package pl.poznan.put.bootstrapbuilder.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

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
                                      @RequestParam(value = "description") String description, @RequestParam(value = "image") String image,
                                      @RequestParam(value = "headerVersion") String headerVersion, @RequestParam(value = "seoVersion") String seoVersion) {

        logger.debug(String.valueOf(header));
        logger.debug(String.valueOf(footer));
        logger.debug(title);
        logger.debug(type);
        logger.debug(description);
        logger.debug(image);
        logger.debug(headerVersion);
        logger.debug(seoVersion);

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
        logger.debug(bootstrap.toString());

        return bootstrap.getBootstrap();
    }

}
