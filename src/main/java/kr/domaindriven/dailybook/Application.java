package kr.domaindriven.dailybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

/**
 * <p>
 *     애플리케이션 시작점이며 다음 환경 설정을 한눈에 보이게 하기 위해 프로그래밍으로 한다.
 *     <ul>
 *         <li>JPA SQL 보이기</li>
 *         <li>Hibernate ddl 자동 검증</li>
 *     </ul>
 * </p>
 *
 * @author Younghoe Ahn
 * @author Jerry Ahn
 */
@RestController
@SpringBootApplication
@ImportResource("classpath:/spring/spring-config.xml")
public class Application {

    public static void main(String... args){
        System.setProperty("spring.jpa.show-sql", "true");
        System.setProperty("spring.jpa.hibernate.ddl-auto", "validate");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println(context.getBean(ConversionService.class));
    }

    /**
     * <p>Thymeleaf에서 제공하는 {@link Java8TimeDialect} 사용을 위해 등록</p>
     * @return
     */
    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }


    /**
     * <p>기동 여부만 파악하기 위한 페이지</p>
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "Hello, World!";
    }

}
