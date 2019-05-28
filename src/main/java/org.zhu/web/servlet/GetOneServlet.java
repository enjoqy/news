package org.zhu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.zhu.domain.Informations;
import org.zhu.service.InformationsService;
import org.zhu.service.impl.InformationsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author junhi
 * @Date 2019/5/27 19:22
 */
@WebServlet("/getOneServlet")
public class GetOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数id
        int id = Integer.parseInt(req.getParameter("id"));

        InformationsService service = new InformationsServiceImpl();
        //直接调用getOne（）获取一条数据
        Informations informations = service.getOne(id);

        //调用updateReplyCount()查看次数+1
        int rows = service.updateReplyCount(id);


//        相应数据
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(), informations);
    }
}
