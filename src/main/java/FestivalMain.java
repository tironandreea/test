import domain.Artist;
import domain.Bilet;
import domain.Spectacol;
import repository.ArtistRepository;
import repository.BiletRepository;
import repository.SpectacolRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public class FestivalMain {
    public static void main(String[] args) {
        Properties props=new Properties();
        try {
            props.load(new FileInputStream("bd.config"));
        }catch(IOException e)
        {
            System.out.println("Eroare: " + e);
        }

        ArtistRepository rep=new ArtistRepository(props);
        SpectacolRepository reps=new SpectacolRepository(props);
        BiletRepository repb=new BiletRepository(props);

        //reps.save(new Spectacol(2,"spectacol_2",1,30,10,"12:00","2017-03-14"));
        //rep.save(new Artist(1,"Metallica"));
        //rep.save(new Artist(2,"Godsmack"));
        //reps.delete(2);

        //repb.save(new Bilet(1,1,"popescu ana",2));
        //repb.update(1,new Bilet(1,1,"ana",2));
        //repb.delete(1);
        reps.update(1,new Spectacol(1,"spectacol_1",1,30,10,"10:00","2017-03-13"));

        for(Artist a : rep.findAll())
            System.out.println(a);
        //System.out.println(rep.size());
        System.out.println("");
        for(Spectacol s : reps.findAll())
            System.out.println(s);
        //System.out.println(reps.size());
        System.out.println("");
        for(Bilet b : repb.findAll())
            System.out.println(b);

        //ApplicationContext context=new ClassPathXmlApplicationContext("AppFestival.xml");
        //ArtistService service=context.getBean(ArtistService.class);
        // ApplicationContext context=new AnnotationConfigApplicationContext(Configurare.class);
        // ArtistService service=context.getBean(ArtistService.class);

        //for(Artist a : service.getAll())
            //System.out.println(a);

    }
}
