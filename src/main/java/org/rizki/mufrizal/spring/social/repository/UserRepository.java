package org.rizki.mufrizal.spring.social.repository;

import org.rizki.mufrizal.spring.social.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 6:00 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.repository
 * @File UserRepository
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
