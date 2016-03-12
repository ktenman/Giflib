package eu.estimol.giflib.data;

import eu.estimol.giflib.model.Gif;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;


public class GifRepository {
    List<Gif> ALL_GIFS;

    public GifRepository() throws IOException {
        Path dir = Paths.get("build\\resources\\main\\static\\gifs");
        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{gif}")) {
            for (Path entry: stream) {
                result.add(entry);
            }
        } catch (DirectoryIteratorException ex) {
            // I/O error encounted during the iteration, the cause is an IOException
            throw ex.getCause();
        }
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        for (Path r: result) {
            ALL_GIFS.add(new Gif(
                    FilenameUtils.getBaseName(r.getFileName().toString()),
                    randomBirthDate,
                    getRandomString() + " " + getRandomString(),
                    random.nextBoolean()
            ));
        }

    }

    private String getRandomString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    public static void main(String[] args) throws IOException {
        new GifRepository();
    }
}
