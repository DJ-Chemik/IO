package pl.poznan.put.bootstrapbuilder.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.put.bootstrapbuilder.logic.BootstrapBuilder;

@RestController
public class BootstrapBuilderController {

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ResponseEntity<Object> getBootstrap() {
        // TODO: implement method
        return null;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.POST)
    public ResponseEntity<Object> setBootstrap(@RequestBody BootstrapBuilder bootstrap) {
        // TODO: implement method & create BootstrapBuilder ^^^^^^^^^^^^^^^^
        return null;
    }

}
