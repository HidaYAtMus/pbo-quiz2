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
public class Item {
    //variable dari item nama
    private String nama;
    //variable dari item harga
    private float harga;
    //variable dari item jumlah
    private int jumlah;
     //constructor
    public Item() {
    }

    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
    //getter nama
    public String getNama() {
        return nama;
    }
    
    //setter nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    //getter harga
    public float getHarga() {
        return harga;
    }

    //setter harga    
    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    //getter jumlah
    public int getJumlah() {
        return jumlah;
    }

    //setter jumlah
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
