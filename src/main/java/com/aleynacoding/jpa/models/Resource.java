package com.aleynacoding.jpa.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import lombok.experimental.SuperBuilder;
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@Builder //Design pattern
//@SuperBuilder
@Data
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) for discriminatorcolumn
//@DiscriminatorColumn(name = "resource type") RIGHT HERE ONLY WITH SINGLE TABLE
public class Resource   { //parent class
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int size;
    private String url;
    @OneToOne
    @JoinColumn(name = "lecture id") // foreign key
    private Lecture lecture;



}
