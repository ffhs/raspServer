package net.p45q.raspberryspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KeepAliveController {
    @RequestMapping("/keepalive")
    public KeepAlive keepAlive(@RequestParam(value="increment", defaultValue="green") int increment) {
        return new KeepAlive(increment);}
}
