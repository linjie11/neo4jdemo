package com.example.neo4jdemo.repository;

import com.example.neo4jdemo.entity.node.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


//基础的增删改查Spring Data Neo4j已经封装好在Neo4jRepository里面了
@Repository
public interface UserRepository extends Neo4jRepository<UserNode,Long> {
    @Query("MATCH (n) WHERE id(n) = :#{#userNode.nodeId} SET n.name = :#{#userNode.name},n.age = :#{#userNode.age},n.sex = :#{#userNode.sex} RETURN n")

    UserNode updateByNode(@Param("userNode") UserNode userNode);

}
