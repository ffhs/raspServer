package net.p45q.raspberryspring;

public class StartAction {
	int actionnr;
	public StartAction(int actionnr) {
		this.actionnr = actionnr;
		switch(actionnr)
		{
			case 0:
				new PinOn(2);
				new PinOn(4);
			break;
			case 1:
				new PinOn(3);
				new PinOn(5);
			break;
			case 2:
				new PinOn(2);
				new PinOn(5);
			case 3:
				new PinOn(4);
				new PinOn(3);
			break;
			case 4:
				new PinOn(1);
			case 5:
				new PinOn(0);
			break;
			case 6:
				new PinOn(6);
			break;
			case 7:
				new PinOn(27);
			break;
			case 8:
				new PinOn(0);
				new PinOn(1);
				new PinOn(2);
				new PinOn(3);
				new PinOn(4);
				new PinOn(5);
				new PinOn(6);
				new PinOn(27);
			break;
		}
	}
}
