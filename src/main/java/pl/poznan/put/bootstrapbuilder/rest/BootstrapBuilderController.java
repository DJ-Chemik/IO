package pl.poznan.put.bootstrapbuilder.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poznan.put.bootstrapbuilder.logic.BootstrapBuilder;

@RestController
public class BootstrapBuilderController {

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET, produces = "application/json")
    public String getViaParams(@RequestParam boolean header, @RequestParam boolean footer, @RequestParam String title,
                               @RequestParam String type, @RequestParam String description, @RequestParam String image,
                               @RequestParam boolean headerVersion, @RequestParam int seoVersion) {
        // TODO: implement method
        return null;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.POST, produces = "application/json")
    public String getViaBody(@RequestBody BootstrapBuilder bootstrap) {
        // TODO: implement method
        return null;
    }

}
