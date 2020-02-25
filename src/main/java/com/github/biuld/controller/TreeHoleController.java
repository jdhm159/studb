package com.github.biuld.controller;

import com.github.biuld.dto.CommentParam;
import com.github.biuld.model.TreeHole;
import com.github.biuld.service.TreeHoleService;
import com.github.biuld.util.Result;
import com.github.biuld.util.Result.ErrCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "树洞管理")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class TreeHoleController {
  private TreeHoleService treeHoleService;

  @GetMapping("random")
  @ApiOperation("随机获得一条记录")
  public Result<TreeHole> findRandomRecord(){
    TreeHole result = treeHoleService.findRandomTreeHole();

    if (result == null){
      return Result.error(ErrCode.GET_RANDOM_FAILURE);
    }

    return Result.success("ok",result);
  }

  @GetMapping("keyRecord")
  @ApiOperation("通过关键词随机获得一条相关树洞的mid")
  public Result<Long> findRandomRecord(@RequestParam String key){
    Long result = treeHoleService.findRecordMidByKey(key);

    if (result == 0){
      return Result.error(ErrCode.GET_MID_FAILURE);
    }

    return Result.success("ok",result);
  }
}
