package instagram.presentation.dto;

import instagram.application.auth.data.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegisterReq {

    private String userName;
    private String fullName;
    private String password;
    private String info;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userName(userName)
                .fullName(fullName)
                .password(password)
                .info(info)
                .build();
    }
}
