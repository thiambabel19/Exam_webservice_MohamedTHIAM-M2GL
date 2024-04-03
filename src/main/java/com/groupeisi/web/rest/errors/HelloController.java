package com.groupeisi.web.rest.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    @GetMapping("/helloword")
    public ResponseEntity<String> sayHelloWorld(){
        return ResponseEntity.ok("Je suis MS1");
    }
}
