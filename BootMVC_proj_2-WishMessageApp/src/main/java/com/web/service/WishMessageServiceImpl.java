package com.web.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("WishService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour<12) {
			return "good morning";
		}
		else if(hour<16) {
			return "Good Afternoon";
		}
		else if(hour<20) {
			return "Good Evening";
			
		}
		else {
			return "GoodNight";
		}
		
	}

}
