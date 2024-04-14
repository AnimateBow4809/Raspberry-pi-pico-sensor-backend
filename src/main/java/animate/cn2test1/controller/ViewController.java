package animate.cn2test1.controller;

import animate.cn2test1.entity.MyData;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    MyData gMyData;

    @PostConstruct
    public void h(){
        gMyData =new MyData();
    }

    @RequestMapping("")
    public String getView(Model model){
        model.addAttribute("data", gMyData);
        return "start";
    }

    @PutMapping("/api/temp")
    public String putTemp(@RequestBody MyData myData, Model model){
        gMyData = myData;
        System.out.println(myData);
        model.addAttribute("data", gMyData);
        return "start";
    }


}
