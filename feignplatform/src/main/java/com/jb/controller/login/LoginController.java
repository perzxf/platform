package com.jb.controller.login;


import com.jb.model.AllTree;
import com.jb.model.AllUser;
import com.jb.service.PlatformServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Controller
@Component
public class LoginController {
    @Autowired
    private PlatformServiceApi platformServiceApi;

    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

    /**
     * 固定cron配置定时任务
     */
    @Scheduled(cron = "0/20 * * * * ?")   //每20秒触发一次
    public void doTask(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("当前时间为:"+sdf.format(new Date()));
    }

    /**
     * 登录验证
     * @param allUser
     * @return
     */
    @RequestMapping("queryLogin")
    @ResponseBody
    public HashMap<String, String> queryLogin(AllUser allUser){
        HashMap<String, String> hashMap = new HashMap<>();
        AllUser userLogin=platformServiceApi.queryUserLogin(allUser);
        if(userLogin==null) {
            hashMap.put("code", "2");
            hashMap.put("msg", "用户名不存在请重新输入！");
            return hashMap;
        }
        if(!userLogin.getUserPwd().equals(allUser.getUserPwd())) {
            hashMap.put("code", "3");
            hashMap.put("msg", "密码错误请重新输入！");
            return hashMap;
        }
        hashMap.put("code", "0");
        hashMap.put("status", userLogin.getStatus());
        hashMap.put("msg", "登陆成功进入展示页面！");
        return hashMap;
    }

    /**
     * 左侧树查询
     * @param allTree
     * @return
     */
    @RequestMapping("queryMyTree")
    @ResponseBody
    public List<AllTree> queryMyTree(AllTree allTree){
        return platformServiceApi.queryMyTree(allTree);
    }
}
