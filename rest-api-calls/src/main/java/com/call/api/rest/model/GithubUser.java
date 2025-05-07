package com.call.api.rest.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a GitHub user with basic identifying information.
 * This class is used for deserializing JSON responses from the GitHub API,
 * specifically the user objects returned from endpoints like "/users".
 */
@Getter
@Setter
public class GithubUser {

    private String login;
    private int id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String user_view_type;
    private boolean site_admin;
}
