package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    // 다양한 리턴 타입이 지원됨.
//    List<User> findByName(String name);
//    Optional<User> findByName(String name); // 가능
     Set<User> findByName(String name); // 가능

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    List<User> findFirst1ByName(String name);

    List<User> findTop1ByName(String name);

    // 예약된 키워드 x
    List<User> findLast1ByName(String name);

    // And 사용
    List<User> findByEmailAndName(String email, String name);

}
