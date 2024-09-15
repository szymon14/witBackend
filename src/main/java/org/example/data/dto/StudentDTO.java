package org.example.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private String name;
    private String surname;
    private String courseName;
    private int semester;
}
