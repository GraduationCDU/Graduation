package cdu.gu.common.util;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

public class RequestUtil {
    public static HttpServletRequest handler() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes == null ? null : servletRequestAttributes.getRequest();
    }

    public static UserAgent ua() {
        HttpServletRequest request = RequestUtil.handler();
        if (request == null) {
            return null;
        }
        return UserAgentUtil.parse(request.getHeader("User-Agent"));
    }

    public static String token() {
        HttpServletRequest request = RequestUtil.handler();
        if (request == null) {
            return "";
        }
        String token = request.getHeader("Authorization");
        if (token == null || token.length() == 0 || token.split(" ").length != 2) {
            return "";
        }
        return token.split(" ")[1];
    }

    public static String url() {
        HttpServletRequest request = RequestUtil.handler();
        return request == null ? "" : request.getRequestURL().toString();
    }

    public static String uri() {
        Integer portNumber = port();
        return RequestUtil.domain()
                + (Arrays.asList(443, 80, 0).contains(portNumber) ? "" : ":" + portNumber);
    }

    public static String uriWithProtocol() {
        Integer portNumber = port();
        return RequestUtil.protocol()
                + RequestUtil.domain()
                + (Arrays.asList(443, 80, 0).contains(portNumber) ? "" : ":" + portNumber);
    }

    public static String pathname() {
        HttpServletRequest request = RequestUtil.handler();
        return request == null ? "" : request.getRequestURI();
    }

    public static Integer port() {
        HttpServletRequest request = RequestUtil.handler();
        return request == null ? 0 : request.getServerPort();
    }

    public static String domain() {
        HttpServletRequest request = RequestUtil.handler();
        if (request != null) {
            String requestUrl = request.getRequestURL().toString();
            List<String> urls = Arrays.asList(requestUrl.split("/"));

            return urls.get(2).split(":")[0];
        }
        return null;
    }

    public static String protocol() {
        HttpServletRequest request = RequestUtil.handler();
        if (request != null) {
            String requestUrl = request.getRequestURL().toString();
            List<String> urls = Arrays.asList(requestUrl.split("//"));

            return urls.get(0) + "//";
        }
        return null;
    }
}
