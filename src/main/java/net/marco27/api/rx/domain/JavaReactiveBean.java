package net.marco27.api.rx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "javarx")
public class JavaReactiveBean {

    @Id
    private String id;
    @Indexed
    private String version;

}
