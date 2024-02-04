package com.writerelief.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import com.writerelief.models.Letter;
import com.writerelief.repository.LetterRepository;



@Component
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(LetterRepository repository) {
        return args -> {
            // Check if the repository is empty to avoid re-seeding the database on every
            // restart
            if (repository.count().block() == 0) {
                // Create and save Letter instances
                Letter letter1 = new Letter("Exploring the Great Outdoors", "Jamie Lannister");
                letter1.setTitle("Exploring the Great Outdoors");
                letter1.setContent("There's nothing quite like the experience of hiking through the wilderness...");
                letter1.setDate("2023-02-01");
                letter1.setLikes(150);
                letter1.setBookmarkedUsers(new HashSet<>(Arrays.asList("user123")));
                letter1.setTags(Arrays.asList("adventure", "hiking", "wildlife"));
                letter1.setCategory("Nature");
                letter1.setReadTime("5 min");
                letter1.setLastUpdated("2023-02-02");
                letter1.setVisibility("public");
                letter1.setFeaturedImageUrl("https://example.com/path/to/image.jpg");
                letter1.setSummary("A brief journey into the heart of nature.");
                letter1.setSeoDescription("Explore the beauty of the great outdoors through our latest adventure.");
                letter1.setSlug(letter1.generateSlug(letter1.getTitle()));

                // Repeat for more Letter instances as needed...

                // Save letters to the database
                List<Letter> letters = List.of(letter1 /* , letter2, letter3, ... */);
                repository.saveAll(letters).subscribe(null, error -> System.err.println("Failed to save letters: " + error) // Log or handle the error
                );

            }
        };
    }
}
