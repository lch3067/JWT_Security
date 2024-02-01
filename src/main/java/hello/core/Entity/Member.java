package hello.core.Entity;

import hello.core.memberEnum.Grade;

// 0 객체 : 서로간에 상호작용
    // 한명의 맴버[객체]이면, 그 맴버에 등급에 따라 할인[객체]을해줌
// 1. 추상화 : Member라는 한 사람의 데이터를 입력받는 것, 실제 존재하는 것처럼 구체화 시킨다.
// 2. 상속 : 자주 쓰는 메소드를 인터페이스로부터 상속받아서 사용하는 것
// 3. 다형성 : 정해진 금액 클래스와 정률 클래스 두개의 정책을 서로 바꿔 끼어도 작동 가능한점
              // 인터페이스를 통해서 다양한 역할(메소드)를 구현체(구현)에서 구현 할 수 있음
// 4. 캠슐화 : 민감한 정보들은 암호화하거나 다르게 다루겠지만, 값의 변동으로 시스템에 영향을 줄 수 있는
              // 변수에 private 시키거나 protected 하여 정보 은닉이나 정보 보호 등을 할 수 있습니다.
public class Member {
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
