package com.szmolke.coderslab.submissions.service;

import com.szmolke.coderslab.submissions.exceptions.WorkshopAppException;

public class GroupService {
    public void addUserToGroup(int groupId, String userEmail) {
        throw new WorkshopAppException("User with email: " + userEmail + " already exist in this group");
    }
}
