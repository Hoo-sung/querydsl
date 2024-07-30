package study.querydsl.controller;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            return name.equals(person.name) &&
                    age == person.age;
        }

        return false;
    }

//    @Override
//    public int hashCode() {
//        return 42;
//    }


    /**
     * 속도는 더 느리다. 성능이 아쉽다. 기본 타입이 있으면, 박싱과 언박싱도 거치기 때문
     */
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

    /**
     * 제일 좋은 버전
     */
    public int hashCode() {
        int result = Integer.hashCode(age);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
