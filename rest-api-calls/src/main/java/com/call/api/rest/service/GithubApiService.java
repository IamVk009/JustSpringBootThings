package com.call.api.rest.service;

import com.call.api.rest.model.GithubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Service responsible for communicating with the GitHub API to retrieve user data.
 */
@Service
@RequiredArgsConstructor
public class GithubApiService {

    /**
     * RestTemplate used for performing HTTP requests to external APIs.
     */
    private final RestTemplate restTemplate;

    /**
     * Fetches a list of GitHub users by sending a GET request to the GitHub public API.
     * @return a ResponseEntity containing a list of Github users.
     */
    public ResponseEntity<List<GithubUser>> getUsers() {
        ResponseEntity<List<GithubUser>> githubUsers
                = restTemplate.exchange(
                "https://api.github.com/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubUser>>() {
                });
        /*
                ParameterizedTypeReference is used to correctly deserialize the JSON response into a List of GithubUser objects.
                Java uses type erasure for generics at runtime, which means something like List<GithubUser> becomes just List<?> once compiled.
                Because of this: RestTemplate cannot infer the type of nested generics like List<GithubUser> during deserialization.
                If you used List.class, it wouldn't know that each item is a GithubUser.
        */
        return githubUsers;
    }
}
