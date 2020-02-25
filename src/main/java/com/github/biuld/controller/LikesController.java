package com.github.biuld.controller;

import com.github.biuld.service.LikesService;
import com.github.biuld.util.Result;
import com.github.biuld.util.UidUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api(tags = "点赞管理")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LikesController {

  private LikesService likesService ;

  @GetMapping("likes")
  @ApiOperation("提交点赞")
  public Result<Integer> like(HttpServletRequest request) {
    String uid = UidUtils.getUid(request);

    int count = likesService.findLikesCountByUid(uid);
    if (count>0){
      return Result.error(Result.ErrCode.ERROR_LIKED);
    }
    return Result.success("ok", likesService.toLike(uid));
  }


  @DeleteMapping("likes")
  @ApiOperation("撤消点赞")
  public Result<String> revoke(HttpServletRequest request) {

    String uid = UidUtils.getUid(request);
    likesService.revokeLikes(uid);
    return Result.success();
  }

  @GetMapping("/likes/count")
  @ApiOperation("获得总点赞数")
  public Result<Integer> getTotalCount(HttpServletRequest request) {
    return Result.success("ok",likesService.findLikesTotalCount());
  }

}
