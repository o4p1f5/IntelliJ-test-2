package test.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    // http://localhost:9090/test
    @GetMapping("test") // test 경로로 찾으면 해당 파일로 들어온다.
    public String hello(Model model)
    {
        model.addAttribute("data", "hello!!");
        return "test"; // resource 의 test.html을 찾는다
    }

    // http://localhost:9090/test2?name=hi
    @GetMapping("test2")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name", name);
        return "test2";
    }

    // http://localhost:9090/test3?name=hi
    @GetMapping("test3")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "test3 " + name; // 파일을 찾지 않고 받은 파라미터 그대로 출력
    }

    // http://localhost:9090/test4?name=hi
    @GetMapping("test4")
    @ResponseBody
    public Test testApi(@RequestParam("name") String name)
    {
        Test test = new Test();
        test.setName(name);
        return test; // json 파일 출력
    }

    static class Test
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
