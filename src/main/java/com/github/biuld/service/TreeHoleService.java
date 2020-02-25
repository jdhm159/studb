package com.github.biuld.service;


import com.github.biuld.mapper.LikesMapper;
import com.github.biuld.mapper.TreeHoleMapper;
import com.github.biuld.model.Likes;
import com.github.biuld.model.TreeHole;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TreeHoleService {
  private TreeHoleMapper treeHoleMapper;

  public TreeHole findRandomTreeHole(){
    return treeHoleMapper.findRandomRecord();
  }

  public Long findRecordMidByKey(String key){
    return treeHoleMapper.findRecordMidByKey('%'+key+'%');
  }
}
