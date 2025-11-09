package tesla.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from tesla docker full image with gradle";
    }
}
