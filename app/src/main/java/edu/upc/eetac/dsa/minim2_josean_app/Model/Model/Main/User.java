package edu.upc.eetac.dsa.minim2_josean_app.Model.Model.Main;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josean on 18/12/2017.
 */

public class User implements Parcelable {
    //Private atributes

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("items")
    @Expose
    private List<Item> items;
    @SerializedName("pedidos")
    @Expose
    private List<Pedidos> pedidos;
    @SerializedName("admin")
    @Expose
    private boolean admin;


    //Constructor

    public User () {

    }

    public User(int id, String username, String password,) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.items = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public User(int id, String username, String password, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.items = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setItem (Item i) {
        this.items.add(i);
    }
    public Item getItem(int position) {
        return this.items.get(position);
    }

    public List<Pedidos> getItems() {
        return items;
    }

    public void setItems(List<Pedidos> items) {
        this.items = items;
    }

    public void setItem (Pedido i) {
        this.items.add(i);
    }
    public Pedido getItem(int position) {
        return this.items.get(position);
    }

}
