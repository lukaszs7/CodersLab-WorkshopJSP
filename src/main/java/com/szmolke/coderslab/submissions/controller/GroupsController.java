package com.szmolke.coderslab.submissions.controller;

import com.szmolke.coderslab.submissions.dao.UsersGroupsDao;
import com.szmolke.coderslab.submissions.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/groups/*")
public class GroupsController extends HttpServlet {
    private UsersGroupsDao groupsDao = new UsersGroupsDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String pathInfo = req.getPathInfo();
        final Integer groupId = getGroupIdFromPath(pathInfo);

        if (groupId == null) {
            // /solutions
            final List<UsersGroup> usersGroups = groupsDao.findAll();
            req.setAttribute("groups", usersGroups);
            System.out.println("Found " + usersGroups.size() + " user groups. " + usersGroups.toString());
            getServletContext().getRequestDispatcher("/WEB-INF/pages/groups.jsp")
                    .forward(req, resp);
        } else {
            // /solutions/1
            final UsersGroup group = groupsDao.read(groupId);
            if (group != null) {
                System.out.println("Found group. " + group.toString());
                req.setAttribute("group", group);
                getServletContext().getRequestDispatcher("/WEB-INF/pages/groupsDetails.jsp")
                        .forward(req, resp);
            } else {
                resp.sendRedirect("/groups");
            }
        }
    }

    private Integer getGroupIdFromPath(String pathInfo) {
        if (pathInfo == null) {
            return null;
        }

        final String[] splitedPath = pathInfo.split("/");
        return Integer.parseInt(splitedPath[1]);
    }
}
