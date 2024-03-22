package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;

import java.util.Set;
import java.util.UUID;

public interface RelationshipService {
    public RelationshipDto sendAddFriendRequest(UUID receiverId);

    public RelationshipDto acceptFriendRequest(UUID relationshipId);

    public Set<RelationshipDto> getPendingFriendRequests(SearchObject searchObject);

    public Set<RelationshipDto> getSentAddFriendRequests(SearchObject searchObject);
}
