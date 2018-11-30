/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Exercises;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class ExercisesDAO implements IBaseDatos<Exercises> {

    @Override
    public List<Exercises> findAll() {
        List<Exercises> exercises = null;
        String query = "SELECT * FROM Exercises";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            String cat = null;
            int eno = 0;
            String topic = null;
            int maxpt = 0;

            while (rs.next()) {
                if (exercises == null) {
                    exercises = new ArrayList<Exercises>();
                }

                Exercises registro = new Exercises();
                cat = rs.getString("cat");
                registro.setCat(cat);

                eno = rs.getInt("eno");
                registro.setEno(eno);

                topic = rs.getString("topic");
                registro.setTopic(topic);

                maxpt = rs.getInt("maxpt");
                registro.setMaxpt(maxpt);

                exercises.add(registro);
            }
            st.close();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ExercisesDAO.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ExercisesDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return exercises;
    }

    @Override
    public boolean insert(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
