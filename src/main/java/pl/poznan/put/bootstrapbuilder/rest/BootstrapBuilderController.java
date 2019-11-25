package pl.poznan.put.bootstrapbuilder.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poznan.put.bootstrapbuilder.logic.BootstrapBuilder;

@RestController
public class BootstrapBuilderController {

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET, produces = "application/json")
    public static String getViaParams(@RequestParam(value = "header") boolean header, @RequestParam(value = "footer") boolean footer,
                                      @RequestParam(value = "title") String title,@RequestParam(value = "type") String type,
                                      @RequestParam(value = "desc") String description, @RequestParam(value = "image") String image,
                                      @RequestParam(value = "headerversion") String headerVersion, @RequestParam(value = "seoversion") String seoVersion) {
        BootstrapBuilder bootstrap = new BootstrapBuilder.Builder().header(header).footer(footer).title(title).type(type).description(description)
                .image(image).headerVersion(headerVersion).seoVersion(seoVersion).build();
        return bootstrap.getBootstrap();
    }

}
