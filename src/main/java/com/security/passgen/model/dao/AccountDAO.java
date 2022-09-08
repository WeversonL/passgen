package com.security.passgen.model.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class AccountDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "service")
    private String serviceName;

    @Column(name = "url")
    private String serviceURL;

    @Column(name = "user")
    private String userName;

    @Column(name = "password")
    private String userPassword;

}
