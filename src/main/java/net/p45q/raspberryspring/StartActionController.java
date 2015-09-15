package net.p45q.raspberryspring;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartActionController {
	@RequestMapping("/startaction")
	public StartAction StopAction(@RequestParam(value="pinnr", defaultValue="0") int actionnr) {
        return new StartAction(actionnr);}
}
