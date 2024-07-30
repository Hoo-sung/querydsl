package study.querydsl.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class PersonTest {

    @Test
    public void equalsTest() throws Exception {
        Person person1 = new Person("jin", 27);
        Person person2 = new Person("jin", 27);
        Assertions.assertThat(person1).isEqualTo(person2);
    }

    @Test
    public void hashCodeTest() throws Exception {
        Person person1 = new Person("jin", 27);
        Person person2 = new Person("jin", 27);

        HashMap<Person, Integer > hashMap = new HashMap<>();
        hashMap.put(person1,1);
        hashMap.put(person2,1);

        Assertions.assertThat(hashMap.size()).isEqualTo(1);

        /**
         * equals가 정상 동작하여도, hasCode가 두 객체에 대해 동일한 해시 코드를 반환하지 않으면, hashmap에서 두 객체가 다른 객체로
         * 인식된다. 그래서 사이즈가 2가 되는 문제가 발생한다.
         */
    }
}