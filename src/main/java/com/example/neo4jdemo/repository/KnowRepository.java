package com.example.neo4jdemo.repository;

import com.example.neo4jdemo.entity.relationship.Know;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface KnowRepository extends Neo4jRepository<Know,Long> {
    @Query("MATCH (fromNode) WHERE id(fromNode)={fromId} MATCH (toNode) WHERE id(toNode) = {toId} MATCH (fromNode)-[r]->(toNode) DELETE r")

    void deleteByNodeId(@Param(value = "fromId") long fromId, @Param(value = "toId") long toId);
}
