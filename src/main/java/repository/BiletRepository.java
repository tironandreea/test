package repository;
import domain.Bilet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public class BiletRepository implements IRepository<Integer,Bilet> {
    private JdbcUtils dbUtils;

    public BiletRepository(Properties props) {
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public int size() {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select count(*) as [SIZE] from Bilete")) {
            try (ResultSet result = preStmt.executeQuery()) {
                if (result.next()) {
                    return result.getInt("SIZE");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error DB " + ex);
        }
        return 0;
    }

    @Override
    public void save(Bilet entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into Bilete values (?,?,?,?)")) {
            preStmt.setInt(1, entity.getId());
            preStmt.setInt(2, entity.getId_spectacol());
            preStmt.setString(3, entity.getCumparator());
            preStmt.setInt(4, entity.getLocuri());
            int result = preStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error DB " + ex);
        }

    }

    @Override
    public void delete(Integer integer) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("delete from Bilete where id=?")) {
            preStmt.setInt(1, integer);
            int result = preStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error DB " + ex);
        }
    }

    @Override
    public void update(Integer integer, Bilet entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("update Bilete set Spectacol=?," +
                "Cumparator=?,Locuri=?  where id=?")) {
            preStmt.setInt(4, integer);
            preStmt.setInt(1, entity.getId_spectacol());
            preStmt.setString(2, entity.getCumparator());
            preStmt.setInt(3, entity.getLocuri());
            int result = preStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error DB " + ex);
        }
    }

    @Override
    public Bilet findOne(Integer integer) {
        Connection con = dbUtils.getConnection();

        try (PreparedStatement preStmt = con.prepareStatement("select * from Bilete where id=?")) {
            preStmt.setInt(1, integer);
            try (ResultSet result = preStmt.executeQuery()) {
                if (result.next()) {
                    int id = result.getInt("id");
                    String cumparator = result.getString("Cumparator");
                    int spectacol = result.getInt("Spectacol");
                    int locuri = result.getInt("Locuri");
                    Bilet s = new Bilet(id, spectacol, cumparator, locuri);
                    return s;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Iterable<Bilet> findAll() {
        Connection con = dbUtils.getConnection();
        List<Bilet> tasks = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Bilete")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String cumparator = result.getString("Cumparator");
                    int spectacol = result.getInt("Spectacol");
                    int locuri = result.getInt("Locuri");
                    Bilet s = new Bilet(id, spectacol, cumparator, locuri);
                    tasks.add(s);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error DB " + e);
        }
        return tasks;
    }
}


