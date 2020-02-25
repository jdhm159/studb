package com.github.biuld.controller;

import com.github.biuld.dto.CommentParam;
import com.github.biuld.service.CommentService;
import com.github.biuld.util.Result;
import com.github.biuld.util.Result.ErrCode;
import com.github.biuld.util.UidUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api(tags = "留言管理")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CommentsController {
  private CommentService commentService;

  @PostMapping("comment")
  @ApiOperation("提交留言，长度限制1000字,每天只能发五次")
  public Result<Integer> doComment(HttpServletRequest request,@RequestBody CommentParam param){

    if (param.getContent().length()>1000){
      return Result.error(ErrCode.COMMENT_LENGTH_TOO_LONG);
    }
    String uid = UidUtils.getUid(request);
    if (commentService.findCommentCountByUidAndLocalDate(uid) >= 5){
      return Result.error(ErrCode.COMMENT_LIMIT);
    }

    int result = commentService.doComment(param.getContent(),uid,param.getContact());
    return Result.success("ok",result);
  }
}
