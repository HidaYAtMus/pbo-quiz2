/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2;

/**
 *
 * @author HP
 */
public class TableModel {
    // columns String array 
     private String[] columns; 
    
    //constructor
    public TableModel() {
        this.columns = new String[] {
            "Nama", "Harga", "Jumlah"
        };
    }
    
    //getter columnname
    public String[] getColumnName() {
        return this.columns;
    }
}
