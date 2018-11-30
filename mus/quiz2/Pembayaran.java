/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2;
import java.util.*;
/**
 *
 * @author HP
 */
public class Pembayaran {
    //variable code 
    private final String code;
    //variable array list
    private ArrayList<Item> items = new ArrayList<>();
    //variable total
    private float total;

    //constructor
    public Pembayaran(String code, ArrayList<Item> items) {
        this.code = code;
        this.items = items;
    }

    //setter total
    public void setTotal() {
        float total = 0;
        for(Item item : this.items){
            total += item.getTotal();
       }
        this.total = total;
    }
    
    //output pembayaran
    public String prtDetail(){
        setTotal();
        String str = "";
        str += "Kode\t\t:"+ this.code+"\n";
        str += " Daftar belanja :\n";
        for(Item item : this.items){
            str += "\t"+ item.getNama()+"(x"+ item.getJumlah()+"):"+item.getTotal()+"\n"; 
        }
        str += "Total\t\t:"+this.total;
        return str;
    }
}
