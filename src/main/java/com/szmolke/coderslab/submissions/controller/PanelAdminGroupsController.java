package com.szmolke.coderslab.submissions.controller;

import com.szmolke.coderslab.submissions.dao.UserDao;
import com.szmolke.coderslab.submissions.dao.UsersGroupsDao;
import com.szmolke.coderslab.submissions.exceptions.WorkshopAppException;
import com.szmolke.coderslab.submissions.model.User;
import com.szmolke.coderslab.submissions.model.UsersGroup;
import com.szmolke.coderslab.submissions.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/panelAdmin/groups/*")
public class PanelAdminGroupsController extends HttpServlet {
    private UsersGroupsDao groupsDao = new UsersGroupsDao();
    private UserDao userDao = new UserDao();
    private GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<UsersGroup> usersGroups = groupsDao.findAll();
        req.setAttribute("groups", usersGroups);

        Integer groupId = getGroupIdFromPath(req.getPathInfo());
        if (groupId == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/admin-groups.jsp")
                    .forward(req, resp);

        } else {
            boolean edit = Boolean.parseBoolean(req.getParameter("edit"));
            final String errorMessage = req.getParameter("errorMessage");
            UsersGroup userGroup = groupsDao.read(groupId);
            req.setAttribute("group", userGroup);
            if (edit) {
                List<User> allUsers = userDao.findAll();
                req.setAttribute("allUsers", allUsers);
                if(errorMessage != null) {
                    req.setAttribute("errorMessage", errorMessage);
                }
                getServletContext().getRequestDispatcher("/WEB-INF/pages/admin-groups-edit.jsp")
                        .forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer groupId = getGroupIdFromPath(req.getPathInfo());
        if (groupId != null) {
            final String groupName = req.getParameter("groupName");
            if (groupName != null) {
                // edit group name
                System.out.println("Edit group " + groupId + " with groupName = " + groupName);
            }
            final String removeUserId = req.getParameter("removeUserFromGroup");
            if (removeUserId != null) {
                int userId = Integer.parseInt(removeUserId);

                // remove user from group
                System.out.println("Remove user " + userId + " from group " + groupId);
            }
            String addUserEmail = req.getParameter("addUserToGroup");
            if (addUserEmail != null) {
                // add user to group
                System.out.println("Add user with emial " + addUserEmail + " to group " + groupId);
                try {
                    groupService.addUserToGroup(groupId, addUserEmail);
                } catch (WorkshopAppException e) {
                    String clientMessage = e.getClientMessage();
                    resp.sendRedirect("/panelAdmin/groups/" + groupId + "?edit=true&errorMessage=" + clientMessage);
                    return;
                }
            }
        }

        resp.sendRedirect("/panelAdmin/groups");
    }

    private Integer getGroupIdFromPath(String pathInfo) {
        if (pathInfo == null) {
            return null;
        }

        final String[] splitedPath = pathInfo.split("/");
        return Integer.parseInt(splitedPath[1]);
    }
}
