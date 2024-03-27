package com.aleynacoding.jpa.models;

import jakarta.persistence.*;
//import jdk.incubator.vector.LongVector;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@Builder //Design pattern
//@SuperBuilder
@Data
@Entity
@NamedQuery(
        name    ="Author.updateByNamedQuery",
        query = "update Author a set a.age=:age"
)

@NamedQuery(name="Author.findByNamedQuery",
        query = "select a from Author  a where a.age>=:age"
)
//@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity {
    //make all the fields private and generate getters and setters

    /*(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )*/
/*    @SequenceGenerator(
            name = "author_sequence",
            sequenceName="author_sequence",
            allocationSize = 1
    )*/
/*@TableGenerator(
        name = "author_id_gen",
        table = "id_generator",
        pkColumnName = "id_name",
        valueColumnName = "id_value",
        allocationSize = 1
)*/

    /////Move it to BAseEntity
  /*  @Id
    @GeneratedValue
    private Integer id;*/ //Integer: value is by default null->
    // hibernate will check the value if the value is null hibernate
    // will create the element
    @Column(
            name = "f_name",
            length = 35

    )
    private String firstname;
    private String lastname;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;
    @Column(
            updatable = false,
            nullable = true
    )
    private LocalDateTime createdAt;
    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//////---------------------------------------------

  public static class AuthorBuilder {
        private String firstname;
        private String lastname;
        private int age;
        private String email;
        public int id;
      public AuthorBuilder id(int id) {
          this.id = id;
          return this;
      }

        public AuthorBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public AuthorBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public AuthorBuilder age(int age) {
            this.age = age;
            return this;
        }

        public AuthorBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Author build() {
            Author author = new Author();
            author.firstname = this.firstname;
            author.lastname = this.lastname;
            author.age = this.age;
            author.email = this.email;
            author.id=this.id;
            return author;
        }

  }

    public  static AuthorBuilder builder() {
        return new AuthorBuilder();
    }
    @ManyToMany(mappedBy = "authors")// inverse of the relationship

    private List<Course> courses;

}
