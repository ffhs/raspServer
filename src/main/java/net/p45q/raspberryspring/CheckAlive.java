package net.p45q.raspberryspring;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckAlive {
	static int lastIncrement = 0;
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
    	if(KeepAlive.currentIncrement > lastIncrement)
    	{
    		System.out.println("Connection still ok");
    	}
    	else
    	{
    		System.out.println("No Ping from Android! Setting all pins to zero");
    		new PinOff(0);
    		new PinOff(1);
    		new PinOff(2);
    		new PinOff(3);
    		new PinOff(4);
    		new PinOff(5);
    		new PinOff(6);
    		new PinOff(27);
    	}
    	lastIncrement = KeepAlive.currentIncrement;
    }
}
