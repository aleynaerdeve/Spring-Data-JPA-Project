package com.aleynacoding.jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
//it will query this video only when I ask for it
//@PrimaryKeyJoinColumn(name = "video id")
//@DiscriminatorValue("V")
public class Video extends Resource {
    private int length;
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }
    @Builder
    public static Video createVideo(String name, int length) {
        Video video = new Video();
        video.setName(video.name);
        video.setLength(length);
        return video;
    }

}
