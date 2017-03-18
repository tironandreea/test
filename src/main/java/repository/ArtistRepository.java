package repository;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
import domain.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ArtistRepository implements IRepository<Integer,Artist> {
    private JdbcUtils dbUtils;

    public ArtistRepository(Properties props){
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public int size() {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("select count(*) as [SIZE] from Artists")) {
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
    public void save(Artist entity) {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("insert into Artists values (?,?)")){
            preStmt.setInt(1,entity.getId());
            preStmt.setString(2,entity.getNume());
            int result=preStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }

    }

    @Override
    public void delete(Integer integer) {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("delete from Artists where id=?")){
            preStmt.setInt(1,integer);
            int result=preStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }
    }

    @Override
    public void update(Integer integer,Artist entity) {
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("update Artists set Nume=?  where id=?")) {
            preStmt.setString(1, entity.getNume());
            preStmt.setInt(2, integer);
            int result=preStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }
    }

    @Override
    public Artist findOne(Integer integer) {
        Connection con=dbUtils.getConnection();

        try(PreparedStatement preStmt=con.prepareStatement("select * from Artists where id=?")){
            preStmt.setInt(1,integer);
            try(ResultSet result=preStmt.executeQuery()) {
                if (result.next()) {
                    int id = result.getInt("Cod");
                    String nume = result.getString("Nume");
                    Artist s = new Artist(id, nume);
                    return s;
                }
            }
        }catch (SQLException ex){
            System.out.println("Error DB "+ex);
        }
        return null;
    }

    @Override
    public Iterable<Artist> findAll() {
        Connection con=dbUtils.getConnection();
        List<Artist> tasks=new ArrayList<>();
        try(PreparedStatement preStmt=con.prepareStatement("select * from Artists")) {
            try(ResultSet result=preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("Nume");
                    Artist task = new Artist(id, nume);
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error DB "+e);
        }
        return tasks;
    }



}
