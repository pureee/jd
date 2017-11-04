package com.pure.jd.entity;

import com.pure.jd.Enum.VerifyCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pure on 2017/7/1.
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class VerifyCode {

    @Id
    @Column(length = 11)
    private String telNumber;

    @Column
    private String code;

    @Column
    private Date createTime;

    @Column
    private Date lastVerifyDate;

    @Column
    private VerifyCodeEnum type;

}
