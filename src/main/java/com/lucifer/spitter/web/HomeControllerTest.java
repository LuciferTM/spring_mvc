package com.lucifer.spitter.web;


import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



public class HomeControllerTest {
    /**
     * 相对于直接调用home()方法测试它的返回值，测试中发起了一个来自/home/的 GET 请求。并且对其结果视图进行断言。
     * 将HomeController的实例传送给MockMvcBuilders.standaloneSetup，并且调用build()方法来创建一个MockMvc实例。
     * 然后，使用MockMvc实例产生了一个GET请求，并且设置了视图的期望。
     */
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        //设置MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/home/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }
}
