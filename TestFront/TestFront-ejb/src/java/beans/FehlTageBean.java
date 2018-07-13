/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dto.TeilnehmerDTO;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless
public class FehlTageBean implements FehlTageBeanLocal {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE = "jdbc:sqlserver://10.140.130.16:1433;databaseName=FehlTageProject21";
    private static final String PASS = "dba21";

    @Override
    public List<TeilnehmerDTO> abfrage1(String name, String vorname, String massnahme) throws ClassNotFoundException, SQLException {

        String sql = String.format("select t.name, t.vorname, count(f.datum)\n"
                + "from Fehltag f join Teilnehmer t\n"
                + "on f.t_id = t.t_id\n"
                + "join Teil_Mass tm\n"
                + "on t.t_id = tm.t_id\n"
                + "join Massnahme m\n"
                + "on tm.m_id = m.m_id\n"
                + "where t.name = '%s' and t.vorname = '%s' and \n"
                + "m.m_id = '%s'\n"
                + "group by t.name, t.vorname", name, vorname, massnahme);

        return getList("1", sql, massnahme);
    }

    @Override
    public List<TeilnehmerDTO> abfrage2(String name, String vorname, String massnahme) throws ClassNotFoundException, SQLException {

        String sql = String.format("select t.name, t.vorname, b.bez, count(distinct f.datum) "
                + "from Teilnehmer t join Teil_Mass tm "
                + "on t.t_id = tm.t_id "
                + "join Massnahme m "
                + "on tm.m_id = m.m_id "
                + "join Mass_Klasse mk "
                + "on m.m_id = mk.m_id "
                + "join Klasse k "
                + "on mk.k_id = k.k_id "
                + "join Block bl "
                + "on k.k_id = bl.k_id "
                + "join Baustein b "
                + "on bl.baustein_id = b.baustein_id "
                + "left join Fehltag f "
                + "on bl.block_id = f.block_id and "
                + "t.t_id = f.t_id "
                + "where t.name = '%s' and t.vorname = '%s' and "
                + "m.m_id = '%s' and "
                + "bl.bis < GETDATE() "
                + "group by t.name, t.vorname, b.bez "
                + "order by 3 ", name, vorname, massnahme);

        return getList("2", sql, massnahme);
    }

    @Override
    public List<TeilnehmerDTO> abfrage3(String name, String vorname, String massnahme, String baustein) throws ClassNotFoundException, SQLException {
        String sql = String.format("select b.bez, count(distinct f.datum)\n"
                + "from Teilnehmer t join Teil_Mass tm\n"
                + "on t.t_id = tm.t_id\n"
                + "join Massnahme m \n"
                + "on tm.m_id = m.m_id\n"
                + "join Mass_Klasse mk\n"
                + "on m.m_id = mk.m_id\n"
                + "join Klasse k\n"
                + "on mk.k_id = k.k_id\n"
                + "join Block bl \n"
                + "on k.k_id = bl.k_id\n"
                + "join Baustein b\n"
                + "on bl.baustein_id = b.baustein_id\n"
                + "left join Fehltag f\n"
                + "on bl.block_id = f.block_id and\n"
                + "t.t_id = f.t_id\n"
                + "where t.name = '%s' and t.vorname = '%s' and \n"
                + "m.m_id = '%s' and \n"
                + "b.baustein_id = '%s'\n"
                + "group by  b.bez", name, vorname, massnahme, baustein);

        return getList("3", sql, name, vorname, massnahme, baustein);
    }

    @Override
    public List<TeilnehmerDTO> abfrage4(String massnahme) throws ClassNotFoundException, SQLException {
        String sql = String.format("select t.name, t.vorname, count(f.datum)\n"
                + "from Fehltag f join Teilnehmer t\n"
                + "on f.t_id = t.t_id\n"
                + "join Teil_Mass tm\n"
                + "on t.t_id = tm.t_id\n"
                + "join Massnahme m\n"
                + "on tm.m_id = m.m_id\n"
                + "where m.m_id = '%s'\n"
                + "group by t.name, t.vorname ", massnahme);
        return getList("4", sql, massnahme);
    }

    @Override
    public List<TeilnehmerDTO> abfrage5(String massnahme, String baustein) throws ClassNotFoundException, SQLException {
        String sql = String.format("select t.name, t.vorname, count(distinct f.datum)\n"
                + "from Teilnehmer t join Teil_Mass tm\n"
                + "on t.t_id = tm.t_id\n"
                + "join Massnahme m \n"
                + "on tm.m_id = m.m_id\n"
                + "join Mass_Klasse mk\n"
                + "on m.m_id = mk.m_id\n"
                + "join Klasse k\n"
                + "on mk.k_id = k.k_id\n"
                + "join Block bl \n"
                + "on k.k_id = bl.k_id\n"
                + "join Baustein b\n"
                + "on bl.baustein_id = b.baustein_id\n"
                + "left join Fehltag f\n"
                + "on bl.block_id = f.block_id and\n"
                + "t.t_id = f.t_id\n"
                + "where m.m_id = '%s' and\n"
                + "b.baustein_id = '%s'\n"
                + "group by t.name, t.vorname", massnahme, baustein);

        return getList("5", sql, massnahme, baustein);
    }

    @Override
    public List<TeilnehmerDTO> abfrage6() throws ClassNotFoundException, SQLException {
        String sql = "select t.name, t.vorname, m.bez, count(f.datum)\n"
                + "from Fehltag f join Teilnehmer t\n"
                + "on f.t_id = t.t_id\n"
                + "join Teil_Mass tm\n"
                + "on t.t_id = tm.t_id\n"
                + "join Massnahme m\n"
                + "on tm.m_id = m.m_id\n"
                + "group by t.name, t.vorname, m.bez";
        return getList("6", sql);
    }

    private List<TeilnehmerDTO> getList(String... arg) throws ClassNotFoundException, SQLException {

        List<TeilnehmerDTO> list = new ArrayList<>();
        Class.forName(DRIVER);
        try (Statement statement = DriverManager.getConnection(DATABASE, PASS, PASS)
                .createStatement()) {
            ResultSet result = statement.executeQuery(arg[1]);
            while (result.next()) {
                switch (arg[0]) {
                    case "1":
                        list.add(new TeilnehmerDTO(result.getString(1), result.getString(2), result.getInt(3), arg[2]));
                        break;
                    case "2":
                        list.add(new TeilnehmerDTO(result.getString(1), result.getString(2), result.getInt(4), arg[2], result.getString(3)));
                        break;
                    case "3":
                        list.add(new TeilnehmerDTO(arg[2], arg[3], result.getInt(2), arg[4], arg[5]));
                        break;
                    case "4":
                        list.add(new TeilnehmerDTO(result.getString(1), result.getString(2), result.getInt(3), arg[2]));
                        break;
                    case "5":
                        list.add(new TeilnehmerDTO(result.getString(1), result.getString(2), result.getInt(3), arg[2], arg[3]));
                        break;
                    case "6":
                        list.add(new TeilnehmerDTO(result.getString(1), result.getString(2), result.getInt(4), result.getString(3), "-"));
                        break;
                }
            }
        }
        return list;

    }

}
