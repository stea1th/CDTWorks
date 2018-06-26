/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "DatumAuswertenBean")
public class DatumAuswerten implements DatumAuswertenLocal, DatumAuswertenRemote {

    @Override
    public String getWochenTag() {
        //return new GregorianCalendar().get(Calendar.)
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    public WochentagUndMonatDTO getWochentagUndMonatDTO() {
        return new WochentagUndMonatDTO(getWochenTag(), new SimpleDateFormat("MMMM").format(new Date()));
    }

}
