package net.p45q.raspberryspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LightSwitchController {
    @RequestMapping("/switch")
    public LightSwitch lightSwitch(@RequestParam(value="led", defaultValue="green") String led) {
        return new LightSwitch(led);}
         
}
