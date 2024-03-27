package com.aleynacoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
//@Builder //Design pattern
//@SuperBuilder
@Data
@Entity
public class Lecture extends BaseEntity {
  /*  @Id
    @GeneratedValue
    private Integer id;*/
    private String name;
    @ManyToOne
    @JoinColumn(name = "section id")// one sectin to many lectures
    private Section section;
    @OneToOne
    @JoinColumn(name = "resource id")
    private Resource resource;

}
