package com.my.java.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JVMInfo {

	@RequestMapping(value = "/jvmInfo")
	public String showThreadStack() {
		StringBuilder sb = new StringBuilder();
		Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
		for (Map.Entry<Thread, StackTraceElement[]> m : allStackTraces.entrySet()) {
			Thread t = (Thread)m.getKey();
			StackTraceElement[] s = (StackTraceElement[])m.getValue();
			if (t.equals(Thread.currentThread())) {
				continue;
			}
			sb.append("</br>\n Thread: ").append(t.getName()).append("</br>\n");
			for (StackTraceElement e : s) {
				sb.append("&nbsp;&nbsp;&nbsp;&nbsp;\t").append(e).append("</br>\n");
			}
		}
		System.out.println("Get jvmInfo succeed.");
		return sb.toString();
	}
}
