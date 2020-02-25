package com.github.biuld.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;

public class IpUtils {
  /**
   * 把字符串IP转换成long
   *
   * @param ipStr 字符串IP
   * @return IP对应的long值
   */
  public static long ip2Long(String ipStr) {
    String[] ip = ipStr.split("\\.");
    return (Long.valueOf(ip[0]) << 24) + (Long.valueOf(ip[1]) << 16)
        + (Long.valueOf(ip[2]) << 8) + Long.valueOf(ip[3]);
  }

  /**
   * 把IP的long值转换成字符串
   *
   * @param ipLong IP的long值
   * @return long值对应的字符串
   */
  public static String long2Ip(long ipLong) {
    StringBuilder ip = new StringBuilder();
    ip.append(ipLong >>> 24).append(".");
    ip.append((ipLong >>> 16) & 0xFF).append(".");
    ip.append((ipLong >>> 8) & 0xFF).append(".");
    ip.append(ipLong & 0xFF);
    return ip.toString();
  }

  /**
   * 从访问请求中获得真实ip地址
   * @param request
   * @return
   */
  public static String getIpAddr(HttpServletRequest request) {
    String ipAddress = null;
    try {
      ipAddress = request.getHeader("x-forwarded-for");
      if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getHeader("Proxy-Client-IP");
      }
      if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getHeader("WL-Proxy-Client-IP");
      }
      if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getRemoteAddr();
        if (ipAddress.equals("127.0.0.1")) {
          // 根据网卡取本机配置的IP
          InetAddress inet = null;
          try {
            inet = InetAddress.getLocalHost();
          } catch (UnknownHostException e) {
            e.printStackTrace();
          }
          ipAddress = inet.getHostAddress();
        }
      }
      // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
      if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
        // = 15
        if (ipAddress.indexOf(",") > 0) {
          ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
      }
    } catch (Exception e) {
      ipAddress = "";
    }
    // ipAddress = this.getRequest().getRemoteAddr();

    return ipAddress;
  }


}