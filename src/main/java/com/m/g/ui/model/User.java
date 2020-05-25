package com.m.g.ui.model;


import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    @NotBlank(message = "Please Enter Name")
    @Size(min = 2, max = 18,message = "Between 2 and 18")
    private String name;

    @NotBlank(message = "Please Enter Email")
    @Email
    private String email;


}