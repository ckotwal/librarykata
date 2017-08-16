package bnymellon.codekata.librarykata.domain;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public class AmazonWebService {

    /**
     * Dummy method to simulate a computationally and time wise expensie call to an external service
     * The results of this should be cached by isbn in the library to avoid subsequent calls to this service
     * @param isbn
     * @return
     */
    public static String determineRating(String isbn) {
        return isbn;
    }
}
