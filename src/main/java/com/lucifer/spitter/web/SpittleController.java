package com.lucifer.spitter.web;

import com.lucifer.spitter.Spitter;
import com.lucifer.spitter.Spittle;
import com.lucifer.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/spitter")
public class SpittleController {

    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

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

    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public String spittles(Map model) {
        // 将spittles添加到model中
        model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));

        // 返回视图名称
        return "spittles";
    }

    //处理查询参数：@RequestParam
    @RequestMapping(value = "/spittles/page",method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count,
                                  Model model){
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return spittleRepository.findSpittles(max,count);
    }

    //通过路径参数传递数据：@PathVariable
    @RequestMapping(value="/spittles/{spittleId}", method=RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittles";
    }

}
