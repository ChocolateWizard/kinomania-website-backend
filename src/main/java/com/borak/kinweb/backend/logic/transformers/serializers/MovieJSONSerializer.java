/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.borak.kinweb.backend.logic.transformers.serializers;

import com.borak.kinweb.backend.domain.dto.classes.ActingDTO;
import com.borak.kinweb.backend.domain.dto.classes.ActingRoleDTO;
import com.borak.kinweb.backend.domain.dto.classes.CritiqueDTO;
import com.borak.kinweb.backend.domain.dto.classes.DirectorDTO;
import com.borak.kinweb.backend.domain.dto.classes.GenreDTO;
import com.borak.kinweb.backend.domain.dto.classes.MovieDTO;
import com.borak.kinweb.backend.domain.dto.classes.WriterDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Mr. Poyo
 */
public class MovieJSONSerializer extends JsonSerializer<MovieDTO> {

    @Override
    public void serialize(MovieDTO movie, JsonGenerator jg, SerializerProvider sp) throws IOException {

        jg.writeStartObject();
        jg.writeNumberField("id", movie.getId());
        jg.writeStringField("title", movie.getTitle());
        jg.writeStringField("cover_image_url", movie.getCoverImageUrl());
        jg.writeStringField("description", movie.getDescription());
        jg.writeStringField("release_date", movie.getReleaseDateAsString());
        jg.writeNumberField("audience_rating", movie.getAudienceRating());
        jg.writeNumberField("critic_rating", movie.getCriticRating());
        writeGenres(jg, movie.getGenres());
        writeDirectors(jg, movie.getDirectors());
        writeWriters(jg, movie.getWriters());
        writeActings(jg, movie.getActings());
        writeCritiques(jg, movie.getCritiques());
        jg.writeEndObject();

    }

    private void writeGenres(JsonGenerator jg, List<GenreDTO> genres) throws IOException {
        jg.writeArrayFieldStart("genres");
        for (GenreDTO genre : genres) {
            jg.writeStartObject();
            jg.writeNumberField("id", genre.getId());
            jg.writeStringField("name", genre.getName());
            jg.writeEndObject();
        }
        jg.writeEndArray();
    }

    private void writeDirectors(JsonGenerator jg, List<DirectorDTO> directors) throws IOException {
        jg.writeArrayFieldStart("directors");
        for (DirectorDTO director : directors) {
            jg.writeStartObject();
            jg.writeNumberField("id", director.getId());
            jg.writeStringField("first_name", director.getFirstName());
            jg.writeStringField("last_name", director.getLastName());
            jg.writeStringField("gender", director.getGender().toString());
            jg.writeStringField("profile_photo_url", director.getProfilePhotoURL());
            jg.writeEndObject();
        }
        jg.writeEndArray();
    }

    private void writeWriters(JsonGenerator jg, List<WriterDTO> writers) throws IOException {
        jg.writeArrayFieldStart("writers");
        for (WriterDTO writer : writers) {
            jg.writeStartObject();
            jg.writeNumberField("id", writer.getId());
            jg.writeStringField("first_name", writer.getFirstName());
            jg.writeStringField("last_name", writer.getLastName());
            jg.writeStringField("gender", writer.getGender().toString());
            jg.writeStringField("profile_photo_url", writer.getProfilePhotoURL());
            jg.writeEndObject();
        }
        jg.writeEndArray();
    }

    private void writeActings(JsonGenerator jg, List<ActingDTO> actings) throws IOException {
        jg.writeArrayFieldStart("actors");
        for (ActingDTO acting : actings) {
            jg.writeStartObject();
            jg.writeNumberField("id", acting.getActor().getId());
            jg.writeStringField("first_name", acting.getActor().getFirstName());
            jg.writeStringField("last_name", acting.getActor().getLastName());
            jg.writeStringField("gender", acting.getActor().getGender().toString());
            jg.writeStringField("profile_photo_url", acting.getActor().getProfilePhotoURL());
            jg.writeBooleanField("is_star", acting.getActor().isIsStar());
            jg.writeArrayFieldStart("roles");
            for (ActingRoleDTO role : acting.getRoles()) {
                jg.writeStartObject();             
                jg.writeNumberField("id", role.getId());
                jg.writeStringField("name", role.getName());
                jg.writeEndObject();
            }
            jg.writeEndArray();
            jg.writeEndObject();
        }
        jg.writeEndArray();

    }

    private void writeCritiques(JsonGenerator jg, List<CritiqueDTO> critiques) throws IOException {
        jg.writeArrayFieldStart("critiques");
        for (CritiqueDTO critique : critiques) {
            jg.writeStartObject();
            jg.writeStringField("critic", critique.getCritic().getUsername());
            jg.writeStringField("description", critique.getDescription());
            jg.writeNumberField("rating", critique.getRating());
            jg.writeEndObject();
        }
        jg.writeEndArray();
    }

}