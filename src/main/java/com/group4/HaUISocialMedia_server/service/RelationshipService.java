package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RelationshipService {
    public RelationshipDto sendAddFriendRequest(UUID receiverId);

    public RelationshipDto acceptFriendRequest(UUID relationshipId);

    public Set<RelationshipDto> getPendingFriendRequests(SearchObject searchObject);

    public Set<RelationshipDto> getSentAddFriendRequests(SearchObject searchObject);

    public List<UserDto> getCurrentFriends(SearchObject searchObject);

    public Set<UserDto> getFriendsOfUser(UUID userId, SearchObject searchObject);

    public RelationshipDto unFriendRequest(UUID relationshipId);

    public List<UserDto> getAllFiends();
}
