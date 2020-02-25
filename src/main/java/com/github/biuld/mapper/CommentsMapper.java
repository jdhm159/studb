package com.github.biuld.mapper;


import com.github.biuld.model.Comments;
import com.github.biuld.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
  @Select("SELECT COUNT(id) FROM comments WHERE uid=#{uid} And created_at BETWEEN #{beginTime} AND #{endTime}")
  int findCommentsCountByUidAndLocalDate(String uid,String beginTime,String endTime);
}