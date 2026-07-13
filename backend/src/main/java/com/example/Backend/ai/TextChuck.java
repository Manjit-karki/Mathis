package com.example.Backend.ai;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextChuck {
    private Integer chuckIndex;
    private String  content;
    private Integer startChar;
    private Integer endChar;
}
