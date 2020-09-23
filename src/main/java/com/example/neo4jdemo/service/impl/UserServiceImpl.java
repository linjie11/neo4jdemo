package com.example.neo4jdemo.service.impl;

import com.example.neo4jdemo.entity.node.UserNode;
import com.example.neo4jdemo.entity.relationship.Know;
import com.example.neo4jdemo.repository.KnowRepository;
import com.example.neo4jdemo.repository.UserRepository;
import com.example.neo4jdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KnowRepository knowRepository;

    @Override
    public UserNode create(UserNode userNode) {
        return userRepository.save(userNode);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserNode> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserNode> findAll() {
        return (List<UserNode>) userRepository.findAll();
    }

    @Override
    public Know addIKnows(UserNode fromNode, UserNode toNode) {
        Know newKnow = new Know(fromNode,toNode);

        return knowRepository.save(newKnow);
    }

    @Override
    public UserNode updateByNode(UserNode userNode) {
        return userRepository.updateByNode(userNode);
    }

    @Override
    public void deleteKnowByNodeId(long fromId, long toId) {
        knowRepository.deleteByNodeId(fromId,toId);
    }
}
