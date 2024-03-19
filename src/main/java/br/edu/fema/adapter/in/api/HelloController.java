package br.edu.fema.adapter.in.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{name}")
    public ResponseEntity<String> hello(
            @PathVariable("name") String name) {
        final String message = "Hello, " + name;
        return ResponseEntity.ok(message);
    }

}
