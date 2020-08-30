package net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.message;

import java.util.List;
import java.util.stream.Collectors;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.User;

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
