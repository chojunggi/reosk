package com.kiosk.reosk.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")

public class User {

    @Id
    private String ponNum;
    private String username;
    private String nickname;
    private String   age;
    private String   sex;

    // getters and setters
}