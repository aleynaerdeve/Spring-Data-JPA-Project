package com.aleynacoding.jpa;
import com.aleynacoding.jpa.models.Author;
import com.aleynacoding.jpa.models.Video;
import com.aleynacoding.jpa.repositories.AuthorRepository;
//import com.fasterxml.jackson.core.JsonFactory;
import com.aleynacoding.jpa.repositories.VideoRepository;
import com.aleynacoding.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean //always public
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	)
	{
		return args -> {
		for(int i =0; i<50; i++) {
			Faker faker = new Faker();
			var author = Author.builder()
					.firstname(faker.name().firstName())
					.lastname(faker.name().lastName())
					.age(faker.number().numberBetween(19, 50))
					.email(faker.name().username() + "aleyna@mail.com") //email unique
					.build();
			//repository.save(author);

		}
			//Update author with id 1

			var author = Author.builder()
					.id(1)
					.firstname("Aleyna")
					.lastname("Erdeve")
					.age(22)
					.email( "aleyna@mail.com") //email unique
					.build();
			repository.save(author);


			//update Author a srt a.age=34 where a.id=1
			//repository.updateAuthor(100,1);

			//update all authors age
			//repository.updateAllAuthorsAges(99);

			//findByNamedQuery
	/*		repository.findByNamedQuery(60)
					.forEach(System.out::println);*/

			//update with named query
			//repository.updateByNamedQuery(12);


	/*		var video= Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);*/

			Specification<Author> specification = Specification
					.where(AuthorSpecification.hasAge(22))
					.or(AuthorSpecification.firstnameLike("A"));
			repository.findAll(specification).forEach(System.out::println);

		};

	}

}
