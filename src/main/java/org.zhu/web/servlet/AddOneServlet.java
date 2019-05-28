package org.zhu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.zhu.domain.Informations;
import org.zhu.service.impl.InformationsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author junhi
 * @Date 2019/5/27 22:05
 */
@WebServlet("/addOneServlet")
public class AddOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        Map<String, String[]> mapper = req.getParameterMap();
        Informations informations = new Informations();
        try {
            BeanUtils.populate(informations, mapper);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(informations);

        //调用service更新
        InformationsServiceImpl service = new InformationsServiceImpl();
        int rows = -1;
        try {
            rows = service.addOne(informations);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rows = 0;
        //7、相应数据
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(String.valueOf(rows));


    }
}
