package validation;

import domain.Artist;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public class ArtistValidator implements IValidator<Artist> {
    @Override
    public void validate(Artist entity) throws ValidationException {
        StringBuffer msg=new StringBuffer();
        if (entity.getId()<0)
            msg.append("Id-ul nu poate fi negativ: " + entity.getId());
        if (msg.length()>0)
            throw new ValidationException(msg.toString());
    }
}