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

@WebServlet("/submissions")
public class SubmissionsController extends HttpServlet {
    private SolutionDao solutionDao = new SolutionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int numberOfSolutions = Integer.parseInt(getServletContext().getInitParameter(AppConfig.NUMBER_OF_SOLUTIONS_KEY_CODE));
        final List<Solution> solutions = solutionDao.findRecent(numberOfSolutions);
        req.setAttribute("solutions", solutions);
        System.out.println("Found " + solutions.size() + " solutions. " + solutions.toString());
        getServletContext().getRequestDispatcher("/WEB-INF/pages/submissions.jsp")
                .forward(req, resp);
    }
}
