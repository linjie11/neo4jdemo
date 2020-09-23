package com.example.neo4jdemo.entity.relationship;

import com.example.neo4jdemo.entity.node.UserNode;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.*;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type = "know")
public class Know {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private UserNode from;
    @EndNode
    private UserNode to;

    public Know() {
    }

    public Know(UserNode from, UserNode to) {
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserNode getFrom() {
        return from;
    }

    public void setFrom(UserNode from) {
        this.from = from;
    }

    public UserNode getTo() {
        return to;
    }

    public void setTo(UserNode to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Know{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
