package com.szmolke.coderslab.submissions.dao;

import com.szmolke.coderslab.submissions.model.Solution;
import com.szmolke.coderslab.submissions.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionDao {
    private UserDao userDao = new UserDao();
    private ExerciseDao exerciseDao = new ExerciseDao();

    public List<Solution> findRecent(int limit) {
        try (Connection conn = DbUtil.getConnection()) {
            List<Solution> solutions = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM SOLUTIONS " +
                    "ORDER BY CREATED_AT " +
                    "LIMIT ?;");
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = createSolutionFromResultSet(resultSet);
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Solution read(int solutionId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM SOLUTIONS WHERE ID = ?");
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createSolutionFromResultSet(resultSet);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Solution createSolutionFromResultSet(ResultSet resultSet) throws SQLException {
        Solution solution = new Solution();
        solution.setId(resultSet.getInt("id"));
        solution.setUpdatedAt(DbUtil.getLocalDateTime(resultSet, "updated_at"));
        solution.setCreatedAt(DbUtil.getLocalDateTime(resultSet, "created_at"));
        solution.setDescription(resultSet.getString("description"));
        // set references
        solution.setAuthor(userDao.read(resultSet.getInt("user_id")));
        solution.setExercise(exerciseDao.read(resultSet.getInt("exercise_id")));
        return solution;
    }
}
