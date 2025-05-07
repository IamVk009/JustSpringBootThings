package com.call.api.rest.controller;

import com.call.api.rest.model.GithubUser;
import com.call.api.rest.service.GithubApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller that exposes endpoints for interacting with GitHub user data.
*/
@RestController
@RequestMapping("/github/api/v1")
@RequiredArgsConstructor
public class GithubApiController {

    private final GithubApiService weatherService;

    /**
     * Handles HTTP GET requests to retrieve a list of GitHub users.
     * @return list of GitHub users.
     */
    @GetMapping("/users")
    public ResponseEntity<List<GithubUser>> getGithubUsers() {
        return weatherService.getUsers();
    }
}
