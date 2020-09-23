package com.example.neo4jdemo.entity.node;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class UserNode {
    @Id
    @GeneratedValue
    private Long nodeId;

    //属性值
    @Property(name = "name")
    private String name;

    @Property(name = "age")
    private int age;

    @Property(name = "sex")
    private String sex;

    //关系节点
    @Relationship(type = "know",direction = Relationship.OUTGOING)
    private Set<UserNode> knows = new HashSet<>();

    public UserNode() {
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<UserNode> getKnows() {
        return knows;
    }

    public void setKnows(Set<UserNode> knows) {
        this.knows = knows;
    }
    public Boolean addKnows(UserNode to){
        return this.knows.add(to);
    }

    @Override
    public String toString() {
        return "UserNode{" +
                "nodeId=" + nodeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
