package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    public void singletonBeanFind() {
        //설정 정보 읽어와서 저장
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        assertThat(singletonBean1).isSameAs(singletonBean2);
        ac.close(); //종료
        }

    //디폴트 빈 설정: 싱글톤(생략가능)
    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct  //초기화 메서드
        public void init() {
            System.out.println("SingletonBean.초기화");
        }
        @PreDestroy     //소멸 메서드
        public void destroy() {
            System.out.println("SingletonBean.소멸");
        }
    }
}
