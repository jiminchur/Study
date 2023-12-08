package com.example.basic.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    
    @NotBlank
    @Size(min = 2, max = 4)
    private String id;
    
    @NotBlank
    @Size(min = 4, max = 8)
    private String pw;

    @NotEmpty
    private String name;

    @Min(value = 0)
    @Max(value = 120)
    private int age;

    @NotNull
    private String address;

    private String phoneNumber;

}
