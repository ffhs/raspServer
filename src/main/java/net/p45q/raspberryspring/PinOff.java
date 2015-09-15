package net.p45q.raspberryspring;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PinOff {
	int pinnr;
	public PinOff(int pinnr) {
		this.pinnr = pinnr;
		// create gpio controller
	    final GpioController gpio = GpioFactory.getInstance();
	    final GpioPinDigitalOutput pin;
	    Pin thispin = null;
	    if(pinnr==0)thispin  = RaspiPin.GPIO_00;
	    if(pinnr==1)thispin  = RaspiPin.GPIO_01;
	    if(pinnr==2)thispin  = RaspiPin.GPIO_02;
	    if(pinnr==3)thispin  = RaspiPin.GPIO_03;
	    if(pinnr==4)thispin  = RaspiPin.GPIO_04;
	    if(pinnr==5)thispin  = RaspiPin.GPIO_05;
	    if(pinnr==6)thispin  = RaspiPin.GPIO_06;
	    if(pinnr==27)thispin  = RaspiPin.GPIO_27;
		pin = gpio.provisionDigitalOutputPin(thispin, "MyLED", PinState.LOW);
	    // set shutdown state for this pin
	    pin.setShutdownOptions(true, PinState.LOW);
	    pin.low();
	    System.out.println("Turned Pin "+pinnr +": Off");
	    pin.clearProperties();
	    
	    gpio.shutdown();
	    gpio.unprovisionPin(pin);
	    
	}
}
