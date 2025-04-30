package instagram.application.auth.service;

import instagram.application.auth.data.UserEntity;
import instagram.application.auth.data.eunms.InformationType;
import instagram.application.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public void registerUser(UserEntity user) {
        InformationType informationType = checkUserInfo(user.getInfo());
        UserEntity userEntity = UserEntity.of(user, informationType);
        userRepository.save(userEntity);
    }

    private InformationType checkUserInfo(String info) {

        info = info.trim().toLowerCase();

        // 이메일 패턴 확인
        if (info.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            return InformationType.EMAIL;
        } else if (info.matches("^(01[0|1|6|7|8|9])[\\d]{3,4}[\\d]{4}$")) {
            return InformationType.PHONE;
        } else {
            throw new IllegalArgumentException("형식이 맞지않습니다.");
        }
    }
}
