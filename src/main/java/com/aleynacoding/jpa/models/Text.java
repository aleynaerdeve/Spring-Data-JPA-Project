package com.aleynacoding.jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Entity
//@DiscriminatorValue("T")
public class Text extends Resource {
    private String content;
}
