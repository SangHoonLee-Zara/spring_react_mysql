package com.hyundaiautoever.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyundaiautoever.boardback.entity.BoardListViewEntity;

@Repository
public interface BoardListViewRepository extends JpaRepository<BoardListViewEntity, Integer> {

    List<BoardListViewEntity> findByOrderByWriteDatetimeDesc();
    List<BoardListViewEntity> findTop3ByWriteDatetimeAfterOrderByFavoriteCountDescCommentCountDescViewCountDescWriteDatetimeDesc(String writeDatetime);
    // @Query("SELECT b FROM board_list_view b WHERE b.writeDatetime > :writeDatetime ORDER BY b.favoriteCount DESC, b.commentCount DESC, b.viewCount DESC, b.writeDatetime DESC")
    // List<BoardListViewEntity> findTop3UsingQuery(@Param("writeDatetime") String writeDatetime);

    List<BoardListViewEntity> findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(String title, String content);
    List<BoardListViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String writerEmail);
    
}
