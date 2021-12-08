package com.thaiitwork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Topic extends  BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    //@JoinColumn(name= "category_id",nullable = false )
    private Category category;

    @NotBlank
    private String title;

    @NotBlank
    private String content;


    //private String file;

    @NotNull
    private Integer numView;

    @NotNull
    private Integer numAnswer;

    @OneToOne
    private User user;

}
