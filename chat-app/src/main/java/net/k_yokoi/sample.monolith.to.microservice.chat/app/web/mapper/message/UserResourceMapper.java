package net.k_yokoi.sample.monolith.to.microservice.chat.app.web.mapper.message;

import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserResourceMapper {

    public static UserResource map(User user){
        return UserResource.builder()
                .userId(user.getUserId())
                .familyName(user.getFamilyName())
                .firstName(user.getFirstName())
                .displayName(user.getDisplayName())
                .imageFilePath(user.getImageFilePath())
                .build();
    }

    public static List<UserResource> map(List<User> users){
        return users.stream().map(UserResourceMapper::map)
                .collect(Collectors.toList());
    }

}
