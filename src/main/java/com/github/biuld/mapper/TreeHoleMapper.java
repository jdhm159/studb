package com.github.biuld.mapper;

import com.github.biuld.model.TreeHole;
import com.github.biuld.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TreeHoleMapper extends BaseMapper<TreeHole> {
  @Select("SELECT * FROM tree_hole WHERE created_at BETWEEN '2019-01-01 00:00:00' AND '2019-12-31 23:59:59' ORDER BY RAND() LIMIT 1")
  TreeHole findRandomRecord();

  @Select("SELECT `mid` FROM tree_hole WHERE created_at BETWEEN '2019-01-01 00:00:00' AND '2019-12-31 23:59:59' AND `text` LIKE #{key} ORDER BY RAND() LIMIT 1")
  Long findRecordMidByKey(@Param("key")String key);
}