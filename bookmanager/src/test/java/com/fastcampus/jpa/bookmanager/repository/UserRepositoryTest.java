package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud() { // create, read, update, delete
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));

//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L,3L,5L));
//
//        users.forEach(System.out::println);

//        User user1 = new User("jack","jack@fastcampus.com");
//        User user2 = new User("steve","steve@fastcampus.com");
//
//        userRepository.saveAll(Lists.newArrayList(user1,user2));
//
//        List<User> users = userRepository.findAll();
//
//        users.forEach(System.out::println);
//        User user = userRepository.getOne(1L);
//
//        System.out.println(user);

//        Optional<User> user = userRepository.findById(1L); // findById로 찾으면 Optional로 래핑되어 반환됨.
//        User user1 = userRepository.findById(1L).orElse(null); // Optional 객체 대신 이렇게 써도 됨.
//
//        System.out.println(user);

//        userRepository.save(new User("new martin", "newmartin@fastcampus.com"));
//
//        userRepository.flush(); // 쿼리에 변화를 주는 것이 아니라 db반영 시점을 조절해주는 것.
//
//        userRepository.findAll().forEach(System.out::println);

//        long count = userRepository.count();
//
//        System.out.println(count);
//
//        boolean exists = userRepository.existsById(1L); // 특이하게 count쿼리를 통해 확인
//
//        System.out.println(exists);

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        userRepository.findAll().forEach(System.out::println);

//        Page<User> users = userRepository.findAll(PageRequest.of(1,3));
//
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

        /*ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name") // 이름은 무시하고. 이 설정을 넣지 않으면 exact 매치가 이루어짐.
                .withMatcher("email",endsWith()); // 이메일이 똑같이 끝나는 걸 매치시켜라

        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

        User user = new User();
        user.setEmail("slow");

        // 이렇게 해도 됨. 생각보다 example을 많이 쓰진 않음.
        ExampleMatcher matcher1 = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example1 = Example.of(user, matcher1);

        // matcher없이 이렇게 넣는다면, exact로 찾음.
        Example<User> example2 = Example.of(new User("ma", "fastcampus.com"));

        userRepository.findAll(example).forEach(System.out::println);
        userRepository.findAll(example1).forEach(System.out::println);*/

        // save는 insert 쿼리 동작
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select(){
/*        System.out.println(userRepository.findByName("dennis"));

        // 동일한 쿼리와 동일한 결과값..!
        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));

        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));

        // Last1과 같이 인식하지 않은 키워드는 JPA 쿼리를 생성할 때 무시하게 됨.
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));*/

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com","martin"));

    }
}