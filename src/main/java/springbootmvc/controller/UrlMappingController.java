package springbootmvc.controller;

// 다양한 url mapping 을 다뤄보겠다.

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UrlMappingController {

    @RequestMapping("/m1") // get, post, put......  다 가능
    public void m1() {
        System.out.println("/m1");
    }


    @RequestMapping(value = "/m2", method = RequestMethod.GET) // get, post, put......  다 가능
    public void m2() {
        System.out.println("/m2");
    }


    @RequestMapping(value = "/m3", method = RequestMethod.POST) // get, post, put......  다 가능
    public void m3() {
        System.out.println("/m3");
    }


    // 위 두가지는 실수 유발할 가능성이 있으므로 @GetMapping, @PostMapping 등을 사용해야한다.

    @GetMapping("/m4")
    public void m4() {
        System.out.println("/m4");
    }

    @PostMapping("/m5")
    public void m5() {
        System.out.println("/m5");
    }

    //path variable
    //client 가 요청 시 보내는  데이터는 기본적으로 parameter 사용
    //대신 요청 url 의 일부에 포함시켜서 보낼 수 도 있다. (REST API)

    //../books?bookId=7 <=parameter 사용
    //../books/7 <= path variable 사용
    @GetMapping("/books/{bookId}")
    public void m6(@PathVariable String bookId) {
        System.out.println("/m6 " + bookId);
    }

    //목록 페이징 limit, offset
    // /list/10/and/20
    @GetMapping("/list/{limit}/{offset}")
    public void m7(@PathVariable int limit, @PathVariable int offset) {
        System.out.println("/m7 " + limit + " and " + offset);
    }

    // 복수의 url mapping
    @GetMapping({"/url1", "/url2"})
    public void m9() {
        System.out.println("/url1, /url2");
    }

    //sub domain 아스터리스크 개수에 따른

    // /sub1 X
    // /sub1/ OK
    // /sub1/abc OK
    // /sub1/abc/def X

    @PostMapping("/sub1/*")
    public void m10() {
        System.out.println("/sub1");
    }


    // /sub2 OK
    // /sub2/ OK
    // /sub2/abc OK
    // /sub2/abc/def OK

    //sub domain
    @PostMapping("/sub2/**")
    public void m11() {
        System.out.println("/sub2");
    }
}
