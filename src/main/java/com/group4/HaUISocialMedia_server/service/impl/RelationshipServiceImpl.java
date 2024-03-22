package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.service.RelationshipService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Override
    public RelationshipDto sendAddFriendRequest(UUID receiverId) {
        return null;
    }

    @Override
    public RelationshipDto acceptFriendRequest(UUID relationshipId) {
        return null;
    }

    @Override
    public Set<RelationshipDto> getPendingFriendRequests(SearchObject searchObject) {
        return null;
    }

    @Override
    public Set<RelationshipDto> getSentAddFriendRequests(SearchObject searchObject) {
        return null;
    }
}
