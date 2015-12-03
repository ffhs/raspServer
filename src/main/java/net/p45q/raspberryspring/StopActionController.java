package net.p45q.raspberryspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StopActionController {
	@RequestMapping("/stopaction")
	public String StopAction(
			@RequestParam(value = "pinnr", defaultValue = "0") int actionnr) {
		new StopAction(actionnr);
		return "stop";
	}
}
