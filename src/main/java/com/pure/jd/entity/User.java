package com.pure.jd.entity;

import lombok.Setter;

import javax.persistence.*;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;

/**
 * Created by pure on 2017/7/2.
 */
@Table
@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String userName;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String address;


}
