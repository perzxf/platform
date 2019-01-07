package com.jb.service.login;

import com.jb.model.AllTree;
import com.jb.model.AllUser;

import java.util.List;

public interface LoginService {

    AllUser queryUserLogin(AllUser allUser);

    List<AllTree> queryMyTreeBuy(AllTree allTree);

    List<AllTree> queryMyTreeSell(AllTree allTree);
}
