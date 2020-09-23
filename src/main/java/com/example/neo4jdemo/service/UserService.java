package com.example.neo4jdemo.service;

import com.example.neo4jdemo.entity.node.UserNode;
import com.example.neo4jdemo.entity.relationship.Know;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //添加User节点
    UserNode create(UserNode userNode);
    //删除
    void deleteById(Long id);
    //查询
    Optional<UserNode> findById(long id);
    //获取所有User节点
    List<UserNode> findAll();

    //添加“知道”关系
    Know addIKnows(UserNode fromNode, UserNode toNode);

    UserNode updateByNode(UserNode userNode);

    void deleteKnowByNodeId(long fromId,long toId);

}
