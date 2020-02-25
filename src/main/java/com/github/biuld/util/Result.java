package com.github.biuld.util;
import lombok.Data;

/**
 * Created by biuld on 2019/8/20.
 */
@Data
public class Result<T> {

  private Integer code;// 操作状态
  private String msg;// 返回信息
  private T data;// 返回数据

  public enum ErrCode {

    ERROR_LIKED(5011,"已经进行过点赞"),
    COMMENT_LENGTH_TOO_LONG(5021,"留言内容长度过长"),
    COMMENT_LIMIT(5022,"您今天已经达到留言次数限制了"),
    GET_RANDOM_FAILURE(5031,"获得随机记录失败"),
    GET_MID_FAILURE(5032,"获得相关树洞失败");

    private Integer code;
    private String msg;

    ErrCode(Integer code, String msg) {
      this.code = code;
      this.msg = msg;
    }

    public String getMsg() {
      return this.msg;
    }

    public Integer getCode() {
      return this.code;
    }
  }

  public static <T> Result<T> success(String msg, T data) {
    Result<T> result = new Result<>();
    result.code = 200;
    result.msg = msg;
    result.data = data;
    return result;
  }

  public static Result<String> success() {
    return success("success!", null);
  }

  public static Result<String> success(String msg) {
    return success(msg, null);
  }

  public static <T> Result<T> error(ErrCode errCode) {
    Result<T> result = new Result<>();
    result.code = errCode.code;
    result.msg = errCode.msg;
    return result;
  }

  @Override
  public String toString() {
    return "{" +
        "\"code\":" + code +
        ", \"msg\":\"" + msg + "\"" +
        ", \"data\":\"" + data + "\"" +
        '}';
  }
}

