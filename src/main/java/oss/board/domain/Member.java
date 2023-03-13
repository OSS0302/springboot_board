package oss.board.domain;

import javax.persistence.*;

@Entity

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 자동으로 생성하는것을 IDENTITY라고한다.
    private Long id; // 회원 아이디
    //@Column(name="username") @Column(name="username")라고하면 db에있는 컬럼 username과 맵핑된다.
    private String name; //회원 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
