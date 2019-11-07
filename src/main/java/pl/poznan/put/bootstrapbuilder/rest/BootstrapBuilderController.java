package pl.poznan.put.bootstrapbuilder.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootstrapBuilderController {

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ResponseEntity<Object> getBootstrap() {
        // TODO: implement
        return null;
    }

}
