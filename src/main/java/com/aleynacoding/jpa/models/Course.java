package com.aleynacoding.jpa.models;

import jakarta.persistence.*;
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
public class Course extends BaseEntity{
   /* @Id
    @GeneratedValue
    private Integer id;*/
    private String name;
    private String description;

    @ManyToMany ///owner of the relationship
    @JoinTable( //anotasyonu, ilişkiyi yönetmek için
            // bir ortak tablonun kullanılacağını belirtir.
            name = "authors courses",
            joinColumns = { // İlişki tablosunda bu varlık
                    // sınıfının (course) anahtar sütununu
                    // belirtir.
                    @JoinColumn(name = "course id")
            },
            inverseJoinColumns = {
                    // İlişki tablosunda diğer
                    // varlık sınıfının (author) anahtar
                    // sütununu belirtir.
                    @JoinColumn(name = "author id")
            }
    ) //between  author ve courses

    private List<Author> authors;
    ///one course to many sections
    @OneToMany(mappedBy = "course")
    private List<Section> sections;

}
