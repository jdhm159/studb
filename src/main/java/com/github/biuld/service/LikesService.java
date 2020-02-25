package com.github.biuld.service;


import com.github.biuld.mapper.LikesMapper;
import com.github.biuld.model.Likes;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LikesService {
  private LikesMapper likesMapper;

  /**
   * 通过Uid查找点赞记录数
   * @param uid
   * @return
   */
  public int findLikesCountByUid(String uid){
    Likes likes = new Likes();
    likes.setUid(uid);
    return likesMapper.selectCount(likes);
  }

  /**
   * 获得总点赞数
   * @return
   */
  public int findLikesTotalCount(){
    Likes likes = new Likes();
    return likesMapper.selectCount(likes);
  }

  /**
   * 进行点赞
   * @param uid
   * @return
   */
  public int toLike(String uid){
    Likes likes = new Likes();
    likes.setUid(uid);
    likes.setCreatedAt(LocalDateTime.now());
    int result = likesMapper.insert(likes);
    return result;
  }

  /**
   * 取消点赞
   * @param uid
   * @return
   */
  public int revokeLikes(String uid){
    Likes likes = new Likes();
    likes.setUid(uid);
    int result = likesMapper.delete(likes);
    return result;
  }
}
