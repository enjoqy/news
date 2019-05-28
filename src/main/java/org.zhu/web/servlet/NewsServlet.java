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
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/27 15:27
 */
@WebServlet("/newsServlet")
public class NewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        InformationsService service = new InformationsServiceImpl();
        List<Informations> list = service.getAll();

        //相应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }
}
