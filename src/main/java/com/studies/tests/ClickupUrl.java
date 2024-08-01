package com.studies.tests;

public class ClickupUrl {
    public static final String BASE_URL = "https://api.clickup.com/api/v2";
    public static final String TEAM = "/team";
    public static final String SPACE = "/space";
    public static final String LIST = "/list";
    public static final String TASK = "/task";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getTeamsUrl() {
        return TEAM;
    }

    public static String getTeamUrl(String teamId) {
        return TEAM + "/" + teamId;
    }

    public static String getSpacesUrl(String teamId) {
        return getTeamUrl(teamId) + SPACE;
    }

    public static String getSpaceUrl(String spaceId) {
        return SPACE + "/" + spaceId;
    }

    public static String getListUrl(String spaceId) {
        return SPACE + "/" + spaceId + LIST;
    }

    public static String getTasksUrl(String listId) {
        return LIST + "/" + listId + TASK;
    }

    public static String getTaskUrl(String taskId) {
        return TASK + "/" + taskId;
    }


}
