package com.jb.service;

import com.jb.model.AllTree;
import com.jb.model.AllUser;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("platform")
public interface PlatformServiceApi {

    @RequestMapping("queryUserLoginInfo")
    AllUser queryUserLogin(AllUser allUser);

    @RequestMapping("queryMyTreeInfo")
    List<AllTree> queryMyTree(AllTree allTree);
}
