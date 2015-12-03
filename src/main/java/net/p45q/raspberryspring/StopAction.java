package net.p45q.raspberryspring;

public class StopAction {
	int actionnr;

	public StopAction(int actionnr) {
		super();
		this.actionnr = actionnr;
		switch (actionnr) {
		case 0:
			new PinOff(2);
			new PinOff(4);
			break;
		case 1:
			new PinOff(3);
			new PinOff(5);
			break;
		case 2:
			new PinOff(2);
			new PinOff(5);
		case 3:
			new PinOff(4);
			new PinOff(3);
			break;
		case 4:
			new PinOff(1);
		case 5:
			new PinOff(0);
			break;
		case 6:
			new PinOff(6);
			break;
		case 7:
			new PinOff(27);
			break;
		case 8:
			new PinOff(0);
			new PinOff(1);
			new PinOff(2);
			new PinOff(3);
			new PinOff(4);
			new PinOff(5);
			new PinOff(6);
			new PinOff(27);
			break;
		}
	}
}
