package com.co.activos.msel0001.infrastructure.entryPoints.asyncEventHandler.config;

import oracle.jms.AQjmsFactory;
import oracle.jms.AQjmsSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class JmsConfig {

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;


    @Configuration
    @EnableJms
    public class OracleAQConfiguration {

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            return dataSource;
        }


        @Bean
        public ConnectionFactory connectionFactory() throws Exception {
            return AQjmsFactory.getConnectionFactory((dataSource()));
        }

        @Bean
        public DestinationResolver destinationResolver() {
            return (session, destinationName, pubSubDomain) -> {
                AQjmsSession aqSession = (AQjmsSession) session;
                return aqSession.getQueue("AQ_ADMIN", destinationName); // Utiliza el destinationName dinámicamente.
            };
        }

        @Bean
        public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
            JmsTemplate template = new JmsTemplate(connectionFactory);
            template.setDefaultDestinationName("queue_jms");
            return template;
        }

        @Bean
        public JmsListenerContainerFactory<?> jmsListenerContainerFactory(
                ConnectionFactory connectionFactory) {
            DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
            factory.setConnectionFactory(connectionFactory);
            factory.setDestinationResolver(destinationResolver());
            factory.setSessionTransacted(true);
            return factory;
        }

        @Bean
        public void validarConexion() {
            try (Connection connection = dataSource().getConnection()) {
                System.out.println("Conexión exitosa: " + connection.getMetaData().getDatabaseProductName());
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al conectar con la base de datos", e);
            }

        }


    }
}
