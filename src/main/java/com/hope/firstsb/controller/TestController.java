package com.hope.firstsb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hope.firstsb.annotation.IgnoreToken;
import com.hope.firstsb.domain.po.User;
import com.hope.firstsb.exception.BizException;
import com.hope.firstsb.service.UserService;
import com.hope.firstsb.support.Response;
import com.hope.firstsb.support.ResponseCode;
import com.hope.firstsb.util.RedisUtil;
import com.hope.firstsb.validate.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwh
 */
@RestController
@RequestMapping("/test")
@Validated
public class TestController extends BaseController {
    //    @Autowired
    private UserService userService;
    //    @Autowired
    private RedisUtil redisUtil;

    private RestTemplate restTemplate;

    @Autowired
    public TestController(UserService userService, RedisUtil redisUtil, RestTemplate restTemplate) {
        this.userService = userService;
        this.redisUtil = redisUtil;
        this.restTemplate = restTemplate;
    }

//    public TestController() {
//
//    }

    @GetMapping("/test")
    @IgnoreToken
    public String test() {
//        StringBuilder str = new StringBuilder();
//        for (ResponseCode code : ResponseCode.values()) {
//            str.append("-");
//            str.append(code);
//        }
//        return str.toString();
        ResponseCode code = ResponseCode.SUCCESS;
        return code.getMsg();
    }

    @GetMapping("/test2")
    public Response test2() {
        return Response.fail().addMsg("不存在");
    }

    @GetMapping("/test3")
    public Response test3() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "zzz");
        data.put("age", "27");
        return Response.success().addData(data);
    }

    @GetMapping("/test4")
    public Response test4() {
        List<Map> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, String> data1 = new HashMap<>();
            data1.put("name", "zzz" + i);
            data1.put("age", "27" + i);
            data.add(data1);
        }
        return Response.success().addData(data);
    }

    @GetMapping("/addOne")
    public Response test5() {
        User user = new User();
        user.setUsername("zwh");
        user.setAge(27);
        user.setPassword("123456");
        user.setCreateTime(1580000000);
        user.setPhone("13300000000");
        int res = userService.addUser(user);
        if (res <= 0) {
            return Response.fail();
        }
        return Response.success();
    }

    @GetMapping("/getOne")
    public Response test6() {
        User user = userService.getUserById(1);
        return Response.success().addData(user);
    }

    @GetMapping("/list")
    public Response test7() {
//        List<User> users = userService.getUserList();
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> userService.getUserList());
        return Response.success().addData(pageInfo.getList());
    }

    @GetMapping("/redis")
    public Response test8() {
        User user = userService.getUserById(1);
        redisUtil.set("user:1", user);
        User user2 = (User) redisUtil.get("user:1");
        return Response.success().addData(user2);
    }

    @GetMapping("/redis2")
    public Response test9() {
        Map<String, Object> map = new HashMap<>(3);
        map.put("1", userService.getUserById(18));
        map.put("2", userService.getUserById(19));
        map.put("3", userService.getUserById(20));
        redisUtil.hMSet("users", map);
        List<User> users = new ArrayList<>();
        Map<Object, Object> map2 = redisUtil.hMGet("users");
        for (Object map3 : map2.values()) {
            users.add((User) map3);
        }
        return Response.success().addData(users);
    }

    @GetMapping("/exception")
    public Response test10() {
        throw new BizException(1010101, "hehe");
    }

    @GetMapping("/exception2")
    public Response test11() {
        aaa();
        return Response.success();
    }

    @GetMapping("/exception3")
    public Response test12() {
        throw new NullPointerException();
    }

    @GetMapping("/validate")
    public Response test13(@NotBlank @PhoneNumber String phoneNumber) {

        return Response.success();
    }

    @GetMapping("/resttemp")
    public Response teset14() {
        System.out.println("333");
        return Response.success().addData(restTemplate.getForObject("http://localhost:8080/test/redis2", Object.class));
    }

    @GetMapping("/fastjson")
    public Response teset15() {
        User user = new User();
        user.setUsername("111");
        user.setPassword("222");
        user.setAge(19);
        user.setPhone("13300000000");
        user.setId(1);
        String data = JSON.toJSONString(user.toString());
        return Response.success().addData(data);
    }

    @GetMapping("/thymeleaf")
    public String teset16(Model model) {
        User user = new User();
        user.setUsername("111");
        user.setPassword("222");
        user.setAge(19);
        user.setPhone("13300000000");
        user.setId(1);
        model.addAttribute("user", user);
        return "user";
    }

    private void aaa() {
        bbb();
    }

    private void bbb() {
        ccc();
    }

    private void ccc() {
        int a = 10 / 0;
    }
}
