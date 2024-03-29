package controller;

import model.ResultBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/resultat" )
public class ResultController extends HttpServlet {

    private static final String PAGE_RESULT_JSP = "/WEB-INF/jsp/result.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        ResultBean bean = new ResultBean();
        req.setAttribute( "resultBean", bean );
        try {
            bean.recupResultat( req );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getServletContext().getRequestDispatcher( PAGE_RESULT_JSP ).forward( req, resp );
    }
}
