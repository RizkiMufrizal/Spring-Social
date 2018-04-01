package org.rizki.mufrizal.spring.social.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 5:59 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.domain
 * @File User
 */

@Entity
@Table(name = "tb_user")
@Data
public class User implements Serializable {

    @Id
    private String username;

    private String password;
}
