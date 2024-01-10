package hello.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString //와 대박이네 투스트링을 해주네 심지어 배열까지
@RequiredArgsConstructor //와 진짜 대박이네 생성자를 해주네
public class HelloLombok {
    final private String name;
    final private int age;
    private String[] likes = {"icecream", "book", "cat"};

    public static void main(String[] args) {
//        HelloLombok helloLombok = new HelloLombok();
//
//        System.out.println("롬복: " + helloLombok);
    }
}
