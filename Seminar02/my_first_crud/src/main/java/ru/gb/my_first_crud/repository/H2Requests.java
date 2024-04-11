package ru.gb.my_first_crud.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "h2.db.request")
@ConfigurationPropertiesScan
@Data
public class H2Requests {
    private String selectAll;
    private String insertNewUser;
    private String deleteById;
    private String updateUser;

}
