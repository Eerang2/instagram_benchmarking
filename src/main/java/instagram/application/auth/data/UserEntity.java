package instagram.application.auth.data;

import instagram.application.auth.data.eunms.InformationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_key")
    private Long id;
    private String fullName;    // 성명
    private String userName;    // 사용자 이름
    private String password;
    private String info;    // 정보

    @Enumerated(EnumType.STRING)
    private InformationType type; // 정보 타입(email, phone)

    public static UserEntity of(UserEntity user, InformationType type) {
        return new UserEntity(user.getFullName(), user.getUserName(), user.getPassword(), user.getInfo(), type);
    }

    public UserEntity(String fullName, String userName, String password, String info, InformationType type) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.info = info;
        this.type = type;
    }
}
