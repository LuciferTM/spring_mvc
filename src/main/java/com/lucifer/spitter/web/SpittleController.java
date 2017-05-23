package com.lucifer.spitter.web;

import com.lucifer.spitter.Spitter;
import com.lucifer.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
@RequestMapping("/spitter")
public class SpittleController {

    private SpittleRepository spittleRepository;

    public SpittleController(){

    }

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Map model) {
        // 将spittles添加到model中
        model.put("spittles", spittleRepository.findSpittles(Long.MAX_VALUE, 20));

        // 返回视图名称
        return "spittles";
    }
}
