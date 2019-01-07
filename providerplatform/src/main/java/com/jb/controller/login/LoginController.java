package com.jb.controller.login;

import com.jb.model.AllTree;
import com.jb.model.AllUser;
import com.jb.service.PlatformServiceApi;
import com.jb.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController implements PlatformServiceApi {
    @Autowired
    private LoginService loginService;

    @Override
    public AllUser queryUserLogin(@RequestBody AllUser allUser) {
        return loginService.queryUserLogin(allUser);
    }

    @Override
    public List<AllTree> queryMyTree(@RequestBody AllTree allTree) {
        if(!"2".equals(allTree.getStatus())){
            allTree.setPid("111");
            return loginService.queryMyTreeBuy(allTree);
        }else {
            allTree.setPid("222");
            return loginService.queryMyTreeSell(allTree);
        }
    }
}
