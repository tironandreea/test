package validation;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public interface IValidator<E> {
    void validate(E entity) throws ValidationException;
}
