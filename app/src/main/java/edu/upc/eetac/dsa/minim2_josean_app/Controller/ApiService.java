package edu.upc.eetac.dsa.minim2_josean_app.Controller;

import edu.upc.eetac.dsa.minim2_josean_app.Model.Model.Main.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Josean on 18/12/2017.
 */

public interface ApiService {
    @POST("user/login")
    Call<User> getUserLoginService (@Body User user);



}
