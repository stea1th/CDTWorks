/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stea1th
 */
@Remote
public interface ControllerRemote {
    public void artikelAusDemWarenkorb(ArtikelDTO artikel, int menge) throws ClassNotFoundException, SQLException;
    public void artikelInsWarenkorb(ArtikelDTO artikel, int menge) throws ClassNotFoundException, SQLException;
    public List<ArtikelDTO> getAllArtikels() throws SQLException, ClassNotFoundException;
    public ArtikelDTO getArtikelById(int id) throws SQLException;
    public ArtikelDTO getWarenkorbById(int id);
    public List<ArtikelDTO> getWarenkorb();
}
