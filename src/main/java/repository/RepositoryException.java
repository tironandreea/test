package repository;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public class RepositoryException extends RuntimeException {
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Exception ex) {
        super(ex);
    }
}
