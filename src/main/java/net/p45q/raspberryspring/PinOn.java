package net.p45q.raspberryspring;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PinOn {
	int pinnr;

	public PinOn(int pinnr) {
		this.pinnr = pinnr;
		// create gpio controller
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput pin;
		Pin thispin = null;
		if (pinnr == 0)
			thispin = RaspiPin.GPIO_00;
		if (pinnr == 1)
			thispin = RaspiPin.GPIO_01;
		if (pinnr == 2)
			thispin = RaspiPin.GPIO_02;
		if (pinnr == 3)
			thispin = RaspiPin.GPIO_03;
		if (pinnr == 4)
			thispin = RaspiPin.GPIO_04;
		if (pinnr == 5)
			thispin = RaspiPin.GPIO_05;
		if (pinnr == 6)
			thispin = RaspiPin.GPIO_06;
		if (pinnr == 27)
			thispin = RaspiPin.GPIO_27;

		// Protection to avoid motordamage:
		// //////////////////////////////
		if (pinnr == 0) {
			GpioPinDigitalOutput checkPin = gpio
					.provisionDigitalOutputPin(RaspiPin.GPIO_01);

			if (checkPin.getState() == PinState.HIGH) {
				System.out.println("Did not turn " + pinnr
						+ ": ON because pin 1 is HIGH");
				gpio.unprovisionPin(checkPin);
				return;
			}

			gpio.unprovisionPin(checkPin);

			// if(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01).getState()==PinState.HIGH){System.out.println("Did not turn "+pinnr
			// +": ON because pin 1 is HIGH");return;}
		}
		if (pinnr == 1) {
			GpioPinDigitalOutput checkPin = gpio
					.provisionDigitalOutputPin(RaspiPin.GPIO_00);

			if (checkPin.getState() == PinState.HIGH) {
				System.out.println("Did not turn " + pinnr
						+ ": ON because pin 0 is HIGH");
				gpio.unprovisionPin(checkPin);
				return;
			}

			gpio.unprovisionPin(checkPin);

			// if(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00).getState()==PinState.HIGH){System.out.println("Did not turn "+pinnr
			// +": ON because pin 0 is HIGH");return;}
		}
		if (pinnr == 2) {
			GpioPinDigitalOutput checkPin = gpio
					.provisionDigitalOutputPin(RaspiPin.GPIO_03);

			if (checkPin.getState() == PinState.HIGH) {
				System.out.println("Did not turn " + pinnr
						+ ": ON because pin 3 is HIGH");
				gpio.unprovisionPin(checkPin);
				return;
			}

			gpio.unprovisionPin(checkPin);

			// if(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03).getState()==PinState.HIGH){System.out.println("Did not turn "+pinnr
			// +": ON because pin 3 is HIGH");return;}
		}
		if (pinnr == 3) {
			GpioPinDigitalOutput checkPin = gpio
					.provisionDigitalOutputPin(RaspiPin.GPIO_02);

			if (checkPin.getState() == PinState.HIGH) {
				System.out.println("Did not turn " + pinnr
						+ ": ON because pin 2 is HIGH");
				gpio.unprovisionPin(checkPin);
				return;
			}

			gpio.unprovisionPin(checkPin);

			// if(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02).getState()==PinState.HIGH){System.out.println("Did not turn "+pinnr
			// +": ON because pin 2 is HIGH");return;}
		}
		if (pinnr == 4) {
			GpioPinDigitalOutput checkPin = gpio
					.provisionDigitalOutputPin(RaspiPin.GPIO_05);

			if (checkPin.getState() == PinState.HIGH) {
				System.out.println("Did not turn " + pinnr
						+ ": ON because pin 5 is HIGH");
				gpio.unprovisionPin(checkPin);
				return;
			}

			gpio.unprovisionPin(checkPin);

			// if(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05).getState()==PinState.HIGH){System.out.println("Did not turn "+pinnr
			// +": ON because pin 5 is HIGH");return;}
		}
		if (pinnr == 5) {
			GpioPinDigitalOutput checkPin = gpio
					.provisionDigitalOutputPin(RaspiPin.GPIO_04);

			if (checkPin.getState() == PinState.HIGH) {
				System.out.println("Did not turn " + pinnr
						+ ": ON because pin 4 is HIGH");
				gpio.unprovisionPin(checkPin);
				return;
			}

			gpio.unprovisionPin(checkPin);

			// if(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04).getState()==PinState.HIGH){System.out.println("Did not turn "+pinnr
			// +": ON because pin 4 is HIGH");return;}
		}
		// /////////////////////////////

		pin = gpio.provisionDigitalOutputPin(thispin, "MyLED", PinState.HIGH);
		// set shutdown state for this pin
		pin.setShutdownOptions(true, PinState.LOW);
		pin.high();
		System.out.println("Turned PIN " + pinnr + ": ON");
		pin.clearProperties();

		gpio.shutdown();
		gpio.unprovisionPin(pin);
	}
}
