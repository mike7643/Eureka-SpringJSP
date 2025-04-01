package springbootmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import springbootmvc.dto.CarDto;

import java.util.Map;

//client -> server 로 전송하는 parameter 처리
//servlet, jsp -> request.getParameter("name")

//Spring 은 넘어오는 파라미터를 최대한 대응하는 메소드의 파라미터에 자동화 시도
@Controller
public class ParamController {

    @GetMapping("/param1")
    public void m1(HttpServletRequest request) {
        System.out.println(request.getParameter("bookId"));
        System.out.println(request.getParameter("bookName"));
    }

    @GetMapping("/param2")
    public void m2(String bookId) {
        System.out.println(bookId);
    }


    @GetMapping("/param3")
    public void m3333(int bookId, String bookName) {
        System.out.println(bookId);
        System.out.println(bookName);
    }


    //Optional int parameter 'book' is present but cannot be translated into a null value due to being declared as a primitive type.
    // 1. 이름으로 matching 되지 않으면 null 처리
    // 2. 메소드의 파라미터 타입이 primitive type
    @GetMapping("/param4")//localhost:8080/param4?bookId=123
    public void m4(int book) { //IllegalStateException
        System.out.println(book);
    }

    @GetMapping("/param5")//localhost:8080/param5?bookId=123
    public void m5(Integer book) { //null
        System.out.println(book);
    }

    @GetMapping("/param6")//localhost:8080/param6?bookId=123
    public void m6(Integer bookId) { //123
        System.out.println(bookId);
    }

    @GetMapping("/param7")//localhost:8080/param7?bookId=123
    public void m7(String bookname) {//null
        System.out.println(bookname);
    }


    //@RequestParam
    //required 속성 (true 가 디폴트)
    @GetMapping("/param8")
    public void m8(@RequestParam String seq) { // 123, warn( bad request 400 )
        System.out.println(seq);
    }

    @GetMapping("/param9")
    public void m9(@RequestParam(required = false) String seq) { // 123, null
        System.out.println(seq);
    }


    @GetMapping("/param10")
    public void m10(@RequestParam(name = "seq2") String seq) { // 123
        System.out.println(seq);
    }

    // Parameter 를 dto 로  => 스프링이 알아서 해준다 !
    // int price가 잘못 되는 경우  => m4 처럼 illegalStateException 발생 하지 않고, 0 default 값으로 자동으로 됨.
    // 기본 생성자가 없을 경우 문제가 없다. <=다른 생성자를 이용
    // 기본 생성자가 없고, 다른 생성자도 없어도 문제가 없다 <= 컴파일러가 제공하는 기본생성자 + setter 이용
    // 기본 생성자가 없고, 다른 생성자도 없고, setter 도 없으면 <= 필드값 파라미터로 초기화 x
    // 기본 생성자가 없고, 다른 생성자는 있고, setter 이 없으면 <= 다른 생성자로 초기화 x
    // price -> price2, setter, getter 는 그대로 : 0
    // setPrice() -> setPrice2(), getPrice() -> getPrice2()
    // 결론 : spring의 파라미터 자동화에서 Dto의 필드를 인식하는 부분 -> setter, getter 로 처리가 된다.
    @GetMapping("/car")//localhost:8080/car?name=volvo&price2=20000&owner=jym
    public void m11(CarDto carDto) {
        System.out.println(carDto);
    }

    // 복수 개의 parameter 를 처리해야 하는데, 몇 개가 될지, Dto 가 존재 x 상황이다 ?
    // @RequestParam Map
    @GetMapping("/map")//localhost:8080/map?name=volvo&price=20000&owner=jym&owner2=yumin
    public void m12(@RequestParam Map<String, String> params) {
        System.out.println(params.get("name"));
        System.out.println(params.get("price"));
        System.out.println(params.get("owner"));
        System.out.println(params.get("owner2"));
    }


    // Header
    @PostMapping("/header")
    public void m13(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader("API-KEY") String apiKey) {
        System.out.println("userAgent = " + userAgent);
        System.out.println("apiKey = " + apiKey);
    }
}
