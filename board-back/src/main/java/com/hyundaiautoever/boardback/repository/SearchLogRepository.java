package com.hyundaiautoever.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hyundaiautoever.boardback.entity.SearchLogEntity;
import com.hyundaiautoever.boardback.repository.resultSet.GetPopularListResultSet;
import com.hyundaiautoever.boardback.repository.resultSet.GetRelationResultSet;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer>{

    @Query(
        value=
        "SELECT search_word as searchWord, count(search_word) AS count " +
        "FROM search_log " +
        "WHERE relation IS FALSE " +
        "GROUP BY search_word " +
        "ORDER BY count DESC " +
        "LIMIT 15 ",
        nativeQuery = true
    )
    List<GetPopularListResultSet> getPopularList();

    @Query(
        value = 
        "SELECT search_word as searchWord, count(search_word) AS count " +
        "FROM search_log " +
        "WHERE relation IS FALSE " +
        "AND relation_word IS NOT NULL " +
        "GROUP BY search_word " +
        "ORDER BY count DESC " +
        "LIMIT 15 ",
        nativeQuery = true
    )
    List<GetRelationResultSet> getRelationList(String searchWord);
    
}
