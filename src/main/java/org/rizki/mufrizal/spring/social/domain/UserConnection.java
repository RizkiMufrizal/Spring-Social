package org.rizki.mufrizal.spring.social.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 07 April 2018
 * @Time 11:31 AM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.domain
 * @File UserConnection
 */
@Entity
@Table(name = "UserConnection",
        indexes = {
                @Index(name = "userId", columnList = "userId", unique = true),
                @Index(name = "providerId", columnList = "providerId", unique = true),
                @Index(name = "rank", columnList = "rank", unique = true)
        }
)
@Data
public class UserConnection implements Serializable {

    @Id
    private String userId;

    private String providerId;

    private String providerUserId;

    private int rank;

    private String displayName;

    private String profileUrl;

    private String imageUrl;

    private String accessToken;

    private String secret;

    private String refreshToken;

    private BigInteger expireTime;
}
