package com.example.Backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
    @Size(min=14,max=4,message="Must have 4 option")
    private List<String> options;
    @NotBlank
    private String question;
    @NotBlank
    private String correctAnswer;
    @Builder.Default
    private String explanation="";
    @Builder.Default
    private Difficulty difficulty = Difficulty.MEDIUM;
}
