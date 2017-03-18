package repository;
import domain.Spectacol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public class SpectacolRepository implements IRepository<Integer,Spectacol> {
    private JdbcUtils dbUtils;

    public SpectacolRepository(Properties props){
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public int size() {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("select count(*) as [SIZE] from Spectacole")) {
            try(ResultSet result = preStmt.executeQuery()) {
                if (result.next()) {
                    return result.getInt("SIZE");
                }
            }
        }catch(SQLException ex){
            System.out.println("Error DB "+ex);
        }
        return 0;
    }

    @Override
    public void save(Spectacol entity) {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("insert into Spectacole values (?,?,?,?,?,?,?)")){
            preStmt.setInt(1,entity.getId());
            preStmt.setInt(2,entity.getId_artist());
            preStmt.setString(3,entity.getData());
            preStmt.setString(4,entity.getOra_incepere());
            preStmt.setInt(5,entity.getLocuri_disponibile());
            preStmt.setInt(6,entity.getLocuri_vandute());
            preStmt.setString(7,entity.getDenumire());
            int result=preStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }

    }

    @Override
    public void delete(Integer integer) {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("delete from Spectacole where id=?")){
            preStmt.setInt(1,integer);
            int result=preStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }
    }

    @Override
    public void update(Integer integer,Spectacol entity) {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("update Spectacole set Artist=?," +
                "Data=?,Ora=?,LocuriDisponibile=?,LocuriVandute=?,Denumire=?  where id=?")) {
            preStmt.setInt(7,integer);
            preStmt.setInt(1,entity.getId_artist());
            preStmt.setString(2,entity.getData());
            preStmt.setString(3,entity.getOra_incepere());
            preStmt.setInt(4,entity.getLocuri_disponibile());
            preStmt.setInt(5,entity.getLocuri_vandute());
            preStmt.setString(6,entity.getDenumire());
            int result=preStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }
    }

    @Override
    public Spectacol findOne(Integer integer) {
        Connection con=dbUtils.getConnection();

        try(PreparedStatement preStmt=con.prepareStatement("select * from Spectacole where id=?")){
            preStmt.setInt(1,integer);
            try(ResultSet result=preStmt.executeQuery()) {
                if (result.next()) {
                    int id = result.getInt("id");
                    String denumire = result.getString("Denumire");
                    int artist=result.getInt("Artist");
                    String dat=result.getString("Data");
                    String ora=result.getString("Ora");
                    int ld=result.getInt("LocuriDisponibile");
                    int lv=result.getInt("LocuriVandute");
                    Spectacol s = new Spectacol(id, denumire,artist,ld,lv,ora,dat);
                    return s;
                }
            }
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }
        return null;
    }

    @Override
    public Iterable<Spectacol> findAll() {
        Connection con=dbUtils.getConnection();
        List<Spectacol> tasks=new ArrayList<>();
        try(PreparedStatement preStmt=con.prepareStatement("select * from Spectacole")) {
            try(ResultSet result=preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String denumire = result.getString("Denumire");
                    int artist=result.getInt("Artist");
                    String dat=result.getString("Data");
                    String ora=result.getString("Ora");
                    int ld=result.getInt("LocuriDisponibile");
                    int lv=result.getInt("LocuriVandute");
                    Spectacol s = new Spectacol(id, denumire,artist,ld,lv,ora,dat);
                    tasks.add(s);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error DB "+e);
        }
        return tasks;
    }



}
