import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import repository.ArtistRepository;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tiron Andreea on 15/03/2017.
 */
@Configuration
public class Configurare {
    @Bean
    @Primary
    public Properties jdbsProps(){
        Properties serverProps=new Properties();
        try {
            serverProps.load(getClass().getResourceAsStream("/bd.config"));
            System.out.println("Properties set. ");
            serverProps.list(System.out);
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);

        }

        return  serverProps;

    }
    @Bean(name="repo")
    public ArtistRepository createRepository(Properties jdbcProps){

        return new ArtistRepository(jdbcProps);
    }

    @Bean(name="artistService")
    public ArtistService taskService(ArtistRepository repo){
        return new ArtistService(repo);
    }

}