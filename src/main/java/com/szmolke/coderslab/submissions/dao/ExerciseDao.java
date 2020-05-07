package com.szmolke.coderslab.submissions.dao;

import com.szmolke.coderslab.submissions.model.Exercise;
import com.szmolke.coderslab.submissions.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseDao {
    public Exercise read(int exerciseId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM EXERCISES WHERE ID = ?");
            statement.setInt(1, exerciseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
                return exercise;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
