package com.szmolke.coderslab.submissions.dao;

import com.szmolke.coderslab.submissions.model.UsersGroup;
import com.szmolke.coderslab.submissions.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersGroupsDao {
    private UserDao userDao = new UserDao();

    public List<UsersGroup> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            List<UsersGroup> usersGroups = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS_GROUPS");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UsersGroup usersGroup = createUsersGroupFromResultSet(resultSet);
                usersGroups.add(usersGroup);
            }
            return usersGroups;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public UsersGroup read(int groupId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS_GROUPS WHERE ID = ?");
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UsersGroup usersGroup = createUsersGroupFromResultSet(resultSet);
                return usersGroup;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private UsersGroup createUsersGroupFromResultSet(ResultSet resultSet) throws SQLException {
        UsersGroup usersGroup = new UsersGroup();
        int groupId = resultSet.getInt("id");
        usersGroup.setId(groupId);
        usersGroup.setName(resultSet.getString("name"));
        usersGroup.setUsers(userDao.findAllByGroupId(groupId));
        return usersGroup;
    }
}
