package com.journaldev.spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.bugsnag.Bugsnag;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Calendar;

@RestController
public class PersonController {
	
	@Autowired
    private Bugsnag bugsnag;
	
	@RequestMapping("/")
	public String welcome() throws Exception {
		InetAddress ip = InetAddress.getLocalHost();
        String hostname = ip.getHostName();
		return "IP : "+ ip +", HOSTNAME : "+hostname;
	}
	
	@Scheduled(fixedRate = 10000)
    public void printLOg() throws Exception {
       System.out.println("Current time is :: " + Calendar.getInstance().getTime());
	   throw new Exception("Unhandled Exception");
    }
	
}
