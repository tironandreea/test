import domain.Artist;
import repository.IRepository;

/**
 * Created by Tiron Andreea on 15/03/2017.
 */
public class ArtistService {
    private IRepository<Integer, Artist> repo;
    public ArtistService(IRepository<Integer, Artist> repo) {

        this.repo = repo;
    }

    public Iterable<Artist> getAll(){
        return repo.findAll();
    }

}