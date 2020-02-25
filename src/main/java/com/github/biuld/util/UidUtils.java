package com.github.biuld.util;

import javax.servlet.http.HttpServletRequest;

public class UidUtils {

  /**
   * 用户联合唯一标识：sha-256(user-agent+ip）
   * 非真正唯一标识：不能识别出使用同一个出口IP、使用同样终端设备/浏览器 的多个用户
   * @param request
   * @return
   */
  public static String getUid(HttpServletRequest request) {
    String ip = IpUtils.getIpAddr(request);
    String userAgent = request.getHeader("User-Agent");
    return Encrypt.SHA256(ip+userAgent);
  }
}
