package com.jb.service.login;

import com.jb.mapper.login.LoginMapper;
import com.jb.model.AllTree;
import com.jb.model.AllUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public AllUser queryUserLogin(AllUser allUser) {
        return loginMapper.queryUserLogin(allUser);
    }

    @Override
    public List<AllTree> queryMyTreeBuy(AllTree allTree) {
        List<AllTree> allTrees = bootTerrNode(allTree);
        return allTrees;
    }

    @Override
    public List<AllTree> queryMyTreeSell(AllTree allTree) {
        List<AllTree> allTrees = bootTerrNode(allTree);
        return allTrees;
    }

    private List<AllTree> bootTerrNode(AllTree allTree) {
        List<AllTree> bootTree= loginMapper.queryMyTree(allTree);
        for(AllTree allBoot : bootTree){
            String id = allBoot.getId();
            allTree.setPid(id);
            List<AllTree> allTrees = bootTerrNode(allTree);
            if(allTrees==null||allTrees.size()<=0) {
                allBoot.setSelectable(true);
            }else {
                allBoot.setSelectable(false);
                allBoot.setNodes(allTrees);
            }
        }
        return bootTree;
    }
}
