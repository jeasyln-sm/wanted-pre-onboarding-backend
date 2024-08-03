package com.recruitment.entity;

import com.recruitment.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;                //사용자 id

    @Column(nullable = false)       //사용자 이름
    private String userName;

    @Column(unique = true)          //사용자 이메일
    private String email;


    public static User createUser(UserDTO userDTO) {
        User user = User.builder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .build();

        return user;
    }
}
