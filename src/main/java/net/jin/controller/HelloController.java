package net.jin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.jin.model.HelloVO;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello RestController for API Check";
	}
	
	@GetMapping("/getHello")
	public HelloVO getHello() {
		HelloVO helloVo = new HelloVO();
		helloVo.setSeq(1);
		helloVo.setTitle("For Jason Value Objet");
		helloVo.setWriter("Jinhyun Nam");
		helloVo.setContent("I love Jee");
		helloVo.setCreateDate(new Date());
		helloVo.setCnt(0);
		return helloVo;
	}
	
	@GetMapping("/getHelloList")
	public List<HelloVO> getHelloList() {
		List<HelloVO> helloList = new ArrayList<HelloVO>();
		for(int i = 0; i <= 10; i++) {
			HelloVO helloVo = new HelloVO();
			helloVo.setSeq(i);
			helloVo.setTitle("Title"+i);
			helloVo.setWriter("Jinhyun Nam");
			helloVo.setContent(i + " contents");
			helloVo.setCreateDate(new Date());
			helloVo.setCnt(0);
			helloList.add(helloVo);
		}
		return helloList;
	}
}
