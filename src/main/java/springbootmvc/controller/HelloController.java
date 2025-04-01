package springbootmvc.controller;

// client 의 request 를 받고 처리

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller// <- 이 annotation 이 있는 클래스의 메소드들의 mapping 정보를 스프링이 수집해서 Handler Mapping 자료구조에 저장
public class HelloController {

    // get /hello
    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello...... !");
        return "hello"; // jsp 로 갈 수 있도록 처리해야함 !
    }
}

// servlet과 비교하여 더 간단하고 쉽게 작성할 수 있음
