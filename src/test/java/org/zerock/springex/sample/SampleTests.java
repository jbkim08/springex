package org.zerock.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    //스프링이 알아서 객체를 생성하여 주입함
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService1() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService); //객체가 널이 아닐때 합격
    }

    @Test
    public void testConnection() throws Exception {
        //데이터소스(커넥션풀)을 이용한 DB 연결 테스트
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();
    }
}
