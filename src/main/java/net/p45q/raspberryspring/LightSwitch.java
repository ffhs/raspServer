package net.p45q.raspberryspring;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LightSwitch {
	String led;
	public LightSwitch(String led) {
		// create gpio controller
	    final GpioController gpio = GpioFactory.getInstance();
	    final GpioPinDigitalOutput pin;

		pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);


	    
	    // provision gpio pin #01 as an output pin and turn on
	    
	
	    // set shutdown state for this pin
	    pin.setShutdownOptions(true, PinState.LOW);
	
	    System.out.println("--> GPIO state should be: ON");
	

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    // turn off gpio pin #01
	    pin.low();
	    System.out.println("--> GPIO state should be: OFF");
	
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

	
	    // toggle the current state of gpio pin #01 (should turn on)
	    pin.toggle();
	    System.out.println("--> GPIO state should be: ON");
	
	   
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	
	    // toggle the current state of gpio pin #01  (should turn off)
	    pin.toggle();
	    System.out.println("--> GPIO state should be: OFF");
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    // turn on gpio pin #01 for 1 second and then off
	    System.out.println("--> GPIO state should be: ON for only 1 second");
	    pin.pulse(1000, true); // set second argument to 'true' use a blocking call
	    
	    // stop all GPIO activity/threads by shutting down the GPIO controller
	    // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
	    
	    pin.clearProperties();
	    gpio.shutdown();
	    gpio.unprovisionPin(pin);
	}
}
