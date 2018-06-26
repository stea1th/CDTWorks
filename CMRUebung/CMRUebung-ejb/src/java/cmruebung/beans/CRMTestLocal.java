/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CRMTestLocal {
    void a();
    void b();
    void c();
    void d();
    void e(Integer managerId);
    void f();
    void g(String countryId);
    void h(String lastName);
}
