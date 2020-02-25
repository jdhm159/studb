package com.github.biuld.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentParam {

  @Size(max = 1000, message = "留言内容不能超过1000个字符")
  @ApiModelProperty(value = "留言内容", required = true)
  String content;

  @ApiModelProperty("联系方式：电话/邮箱")
  String contact;
}
