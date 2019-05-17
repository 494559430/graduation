package com.qdu.task;

import java.util.Date;

import com.qdu.bean.User;
import com.qdu.service.NoticeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Component
public class JobAnno {
	@Resource
	NoticeService service;
	//@Scheduled(cron="0/5 * * * * ?")//cron="0 0 12 * * ?"0/5 * * * * ?
	public void jobAnno(){
		service.buhuoNotice();
	}
	
}
