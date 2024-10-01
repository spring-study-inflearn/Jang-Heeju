package spring_study.spring.beanFind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_study.spring.spring_core_basic.member.Member;
import spring_study.spring.spring_core_basic.member.MemberRespository;
import spring_study.spring.spring_core_basic.member.MemoryMemberRespository;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으롤 조회시 같은 타입이 둘 이상있으면 중복오류가 발생한다")
    void findBeanByTypeDuplicate(){
        MemberRespository bean = ac.getBean(MemberRespository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRespository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByName(){
        MemberRespository memberRespository = ac.getBean("memberRepository1", MemberRespository.class);
        org.assertj.core.api.Assertions.assertThat(memberRespository).isInstanceOf(MemberRespository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRespository> beansOfType = ac.getBeansOfType(MemberRespository.class);
        for (String key : beansOfType.keySet()) {{
            System.out.println("key = "+ key + " value - "+ beansOfType.get(key));
        }
            System.out.println("beansOfType "+ beansOfType);
            org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        }
    }
    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRespository memberRepository1(){
            return new MemoryMemberRespository();
        }
        @Bean
        public MemberRespository memberRepository2(){
            return new MemoryMemberRespository();
        }
    }
}
