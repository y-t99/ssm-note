package cn.yuanyuan.practice01.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * the @RequestMapping annotation map requests to controllers methods.
 * It has various attributes to match
 * by URL, HTTP method, request parameters, headers, and media types.
 * You can use it at the class level
 * to express shared mappings
 * or at the method level to narrow down to a specific endpoint mapping.
 *
 *
 * */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String handle(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index";
    }

    /**
     * declare URI variables and access their values with @PathVariable.
     * URI variables at the class and method levels.
     * 可以声明url变量，并通过@PathVariable获取他们的值。
     * 可以在类和方法上使用。
     *
     * URI variables are automatically converted to the appropriate type,
     * or TypeMismatchException is raised.
     * Type Conversion and DataBinder.
     * 变量的转换。
     *
     * 高级匹配：
     * /@GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
     * "/spring-web-3.0.5 .jar"
     * @param info url变量
     * @return 首页
     */
    @GetMapping("/urlVariables/{info}")
    public String urlVariables(@PathVariable String info){
        System.out.println("info");
        return "index";
    }
    /**接收json请求格式的数据*/
    @PostMapping(value="/consumes",consumes=(MediaType.APPLICATION_JSON_VALUE))
    public String consumes(@RequestBody HashMap<String,Object> map){
        System.out.println(map);
        return "index";
    }
    /**放回json格式的数据*/
    @GetMapping(value = "/produces",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> produces(){
        return new HashMap<>();
    }

    /**
     * Method Arguments
     *
     * Choose any specific request or response type — 
     * for example, ServletRequest, HttpServletRequest,
     * or Spring’s MultipartRequest, MultipartHttpServletRequest.
     * 能够获取上面的请求对象
     *
     * After a MultipartResolver has been enabled,
     * the content of POST requests with multipart/form-data
     * is parsed and accessible as regular request parameters.
     * /@RequestParam("name") String name,
     * /@RequestParam("file") MultipartFile file
     * 能够便捷的获取表单数据对象。
     * */

    @PostMapping("/form/convenient")
    public String formConvenient(@RequestParam("name") String name,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("----表单文件----");
        System.out.println(name);
        System.out.println(file.getSize());
        final InputStream inputStream = file.getInputStream();
        final int read = inputStream.read();
        return "index";
    }
}
/**
 * 当有多个pattern匹配url时：
 * 1. A pattern is less specific
 * if it has a lower count of URI variables (counted as 1), single wildcards (counted as 1),
 * and double wildcards (counted as 2).
 * 2. Given an equal score, the longer pattern is chosen.
 * 3. Given the same score and length,
 * the pattern with more URI variables than wildcards is chosen.
 * 1. 对patter进行计算判断，值高的匹配
 * 2. 值相同，长的patter将被匹配
 * 3. 值和长度相同，url variables比wildcards优先考虑
 *
 *
 * */