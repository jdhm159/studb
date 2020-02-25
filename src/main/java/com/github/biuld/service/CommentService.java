package com.github.biuld.service;

import com.github.biuld.model.Comments;
import com.github.biuld.util.Time;
import com.github.biuld.mapper.CommentsMapper;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CommentService {
  private CommentsMapper commentsMapper;

  public int doComment( String content, String uid,String contact){
    Comments comment = new Comments();
    comment.setContent(content);
    comment.setUid(uid);
    comment.setContact(contact);
    comment.setCreatedAt(LocalDateTime.now());
    return commentsMapper.insert(comment);
  }

  public int findCommentCountByUidAndLocalDate(String uid){
    Time time = new Time();
    return commentsMapper.findCommentsCountByUidAndLocalDate(uid,time.getTodayBegin(),time.getTodayEnd());
  }

}
