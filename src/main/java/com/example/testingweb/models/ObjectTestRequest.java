package com.example.testingweb.models;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class ObjectTestRequest {
    private int atributo1;
    private String atributo2;
    private Long atributo3;
}
