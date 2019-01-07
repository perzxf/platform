package com.jb.mapper.login;

import com.jb.model.AllTree;
import com.jb.model.AllUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    AllUser queryUserLogin(AllUser allUser);

    List<AllTree> queryMyTree(AllTree allTree);
}
