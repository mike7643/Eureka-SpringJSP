package springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import springbootmvc.dto.CarDto;
// 참고로 low 하게 request.setAttribute 해도 된다.
// controller 에서 작업 후 data(model)을 jsp로 보내서 화면 구성 후 client(프론트)로 전송
@Controller
public class ViewController {

    @GetMapping("/viewTest1")
    public String viewTest1() {
        //......
        return "viewTest1";
    }
    @GetMapping("/viewTest2")
    public String viewTest2() {
        //......
        return "sub/viewTest2";
    }


    @GetMapping("/viewTest3")
    public String viewTest3(Model model) {
        // model
        // service - dao 통해서 data 준비

        model.addAttribute("seq", "12345");
        model.addAttribute("carDto", new CarDto("volvo", 20000, "jym"));
        return "viewTest3";
    }

    @GetMapping("/viewTest4")
    public ModelAndView viewTest4() {
        // modelAndView mav
        // service - dao 통해서 data 준비

        ModelAndView mav= new ModelAndView(); // 패키지 위치 참고.
        mav.addObject("seq", "12345");
        mav.addObject("carDto", new CarDto("volvo", 20000, "jym"));
        mav.setViewName("viewTest4");
        return mav;
    }


    @GetMapping("/redirect")
    public String redirect() {
        //......
        return "redirect:/viewTest1";
    }
}
