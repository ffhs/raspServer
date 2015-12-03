package net.p45q.raspberryspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartActionController {
	@RequestMapping("/startaction")
	public String startAction(
			@RequestParam(value = "pinnr", defaultValue = "0") int actionnr) {
		new StartAction(actionnr);
		return "start";
	}
}
