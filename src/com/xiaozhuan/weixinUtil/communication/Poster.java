package com.xiaozhuan.weixinUtil.communication;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class Poster {
    public static boolean post(HttpServletResponse response, String postText)
    {

        // 输出给用户
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.print(postText);
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
