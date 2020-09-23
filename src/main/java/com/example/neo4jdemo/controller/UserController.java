package com.example.neo4jdemo.controller;

import com.example.neo4jdemo.entity.node.UserNode;
import com.example.neo4jdemo.entity.relationship.Know;
import com.example.neo4jdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(path = "/add", method = RequestMethod.POST)

    public UserNode addUserNode(@RequestBody UserNode userNode) {

        return userService.create(userNode);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)

    public int delUserNodeById(@RequestParam(value = "id") long id) {

        userService.deleteById(id);

        System.out.println(id);

        return 1;

    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)

    public UserNode updateUserNodeByNode(@RequestBody UserNode userNode) {

        return userService.updateByNode(userNode);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)

    public UserNode getUserNodeById(@RequestParam(value = "id") long id) {

        Optional<UserNode> optionalUserNode =  userService.findById(id);

        if(optionalUserNode.isPresent()){

            return optionalUserNode.get();

        }else{

            return null;

        }

    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)

    public List<UserNode> getUserNodeList() {

        return userService.findAll();

    }

    @RequestMapping(path = "/addKnows", method = RequestMethod.POST)

    public Know addKnowsById(@RequestParam(value = "from") long fromId, @RequestParam(value = "to") long toId) {

        Optional<UserNode> fromOpt =  userService.findById(fromId);

        Optional<UserNode> toOpt =  userService.findById(toId);

        if(fromOpt.isPresent()&&toOpt.isPresent()){

            return userService.addIKnows(fromOpt.get(),toOpt.get());

        }else{

            return null;

        }

    }

    @RequestMapping(path = "/delKnows", method = RequestMethod.POST)

    public String deleteKnowsByNodeId(@RequestParam(value = "from") long fromId, @RequestParam(value = "to") long toId) {

        Optional<UserNode> fromOpt = userService.findById(fromId);

        Optional<UserNode> toOpt = userService.findById(toId);

        if (fromOpt.isPresent() && toOpt.isPresent()) {

            userService.deleteKnowByNodeId(fromId, toId);

            return "ok";

        } else {

            return "false";
        }
    }


}
