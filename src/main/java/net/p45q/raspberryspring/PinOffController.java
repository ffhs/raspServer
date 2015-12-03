package net.p45q.raspberryspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PinOffController {
	@RequestMapping("/turnoff")
	public PinOff lightOff(
			@RequestParam(value = "pinnr", defaultValue = "green") int pinnr) {
		return new PinOff(pinnr);
	}
}
