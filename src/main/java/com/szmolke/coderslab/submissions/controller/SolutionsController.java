package com.szmolke.coderslab.submissions.controller;

import com.szmolke.coderslab.submissions.config.AppConfig;
import com.szmolke.coderslab.submissions.dao.SolutionDao;
import com.szmolke.coderslab.submissions.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/solutions/*")
public class SolutionsController extends HttpServlet {
    private SolutionDao solutionDao = new SolutionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String pathInfo = req.getPathInfo();
        final Integer solutionId = getSolutionIdFromPath(pathInfo);

        if (solutionId == null) {
            // /solutions
            final int numberOfSolutions = Integer.parseInt(getServletContext().getInitParameter(AppConfig.NUMBER_OF_SOLUTIONS_KEY_CODE));
            final List<Solution> solutions = solutionDao.findRecent(numberOfSolutions);
            req.setAttribute("solutions", solutions);
            System.out.println("Found " + solutions.size() + " solutions. " + solutions.toString());
            getServletContext().getRequestDispatcher("/WEB-INF/pages/solutions.jsp")
                    .forward(req, resp);
        } else {
            // /solutions/1
            final Solution solution = solutionDao.read(solutionId);
            if (solution != null) {
                System.out.println("Found solution. " + solution.toString());
                req.setAttribute("solution", solution);
                getServletContext().getRequestDispatcher("/WEB-INF/pages/solutionDetails.jsp")
                        .forward(req, resp);
            } else {
                resp.sendRedirect("/solutions");
            }
        }
    }

    private Integer getSolutionIdFromPath(String pathInfo) {
        if (pathInfo == null) {
            return null;
        }

        final String[] splitedPath = pathInfo.split("/");
        return Integer.parseInt(splitedPath[1]);
    }
}
