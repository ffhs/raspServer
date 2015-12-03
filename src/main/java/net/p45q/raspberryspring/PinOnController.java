package net.p45q.raspberryspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PinOnController {
	@RequestMapping("/turnon")
	public PinOn lightOn(
			@RequestParam(value = "pinnr", defaultValue = "0") int pinnr) {
		return new PinOn(pinnr);
	}
}
