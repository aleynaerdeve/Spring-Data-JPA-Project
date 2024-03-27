package com.aleynacoding.jpa.models;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@Builder //Design pattern
//@SuperBuilder
@Data
@Entity

public class Section extends BaseEntity{
  /*  @Id
    @GeneratedValue
    private  Integer id;*/
    private String name;
    private int sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course id")

    //many sections belong to one course
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

}
