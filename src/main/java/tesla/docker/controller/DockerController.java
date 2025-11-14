package tesla.docker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tesla.docker.model.QuickSort;
import tesla.docker.entity.User;
import tesla.docker.service.DockerService;

import java.util.UUID;

@RestController("/")
public class DockerController {

    private static final Logger log = LoggerFactory.getLogger(DockerController.class);

    private final DockerService dockerService;

    public DockerController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("hello")
    public String hello() {
        log.info("Hello info");
        log.debug("hello debug");
        String response = ("Hello from tesla docker full image with gradle");
        log.info("Response {}", response);
        //        curl http://localhost:8888/hello

        return response;
    }

    @GetMapping("uuid")
    public UUID uuid() {
        log.info("UUID info");
        log.info("UUID Debug");
        UUID rundomUUID = UUID.randomUUID();
        log.info("Response new random UUID = {}", rundomUUID);
//        curl http://localhost:8888/uuid
        return rundomUUID;
    }

    @GetMapping("head")
    public String head(
            @RequestHeader(value = "id", required = true, defaultValue = "777") String id,
            @RequestHeader(value = "user", required = true, defaultValue = "666") String user
    ) {
        log.info("Start fun head");
//        curl.exe http://localhost:8888/head -H "id: 123" -H "user:KOK"
        return String.format("id=%s, userName =%s!!!", id, user);
    }

    @GetMapping("query")
    public String query(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "sName", required = false, defaultValue = "") String sName
    ) {
//        http://localhost:8888/query?sName=Ivanov&name=Tramp
        return String.format("For you \"%s %s\" uuid is %s", name, sName, UUID.randomUUID());
    }

    @PostMapping("user")
    public String user(@RequestBody User user) {
        log.info("Start curl.exe -H \"Content-Type: application/json\" -d '{\\\"name\\\": \\\"lol\\\", \\\"age\\\": 55}' http://localhost:8888/user");

//        curl.exe -H "Content-Type: application/json" -d '{\"name\": \"lol\", \"age\": 55}' http://localhost:8888/user

        return dockerService.userString(user);
    }

    @GetMapping("sum")
    public Integer sum(
            @RequestParam(name = "x", defaultValue = "0") Integer x,
            @RequestParam(value = "y", defaultValue = "0") Integer y
    ) {
        log.info("Get in controller from http://localhost:8888/sum?x={}&y={}", x, y);
        return dockerService.sum2(x, y);
    }

    @PostMapping("sort")
    public Integer[] quickSort(@RequestBody QuickSort quickSort) {
        log.info("Start quick sort");
        return dockerService.quickSort(quickSort);
    }

    @GetMapping("binar")
    public Integer binar() {
        log.info("Start binary search in Controller or index, where must be number");
        Integer[] arr = new Integer[]{0, 1, 2, 4, 5, 6, 7, 8, 12, 76, 7632, 888888};
        Integer target = 888888;

        return dockerService.binarSearch(arr, target);
    }

    @GetMapping("binarNull")
    public Integer binarNull() {
        log.info("Start binary search in Controller or Integer.MIN_VALUE");
        Integer[] arr = new Integer[]{0, 1, 2, 4, 5, 6, 7, 8, 12, 76, 7632, 888888};
//        Integer[] arr = new Integer[]{1, 2, 4};
        Integer target = 333;

        return dockerService.binarSearchOrNull(arr, target);
    }
}
