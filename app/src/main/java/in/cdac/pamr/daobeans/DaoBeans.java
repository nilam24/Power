package in.cdac.pamr.daobeans;

import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import in.cdac.pamr.pojos.UserDetails;
import static in.cdac.pamr.connectionutils.ConnectionUtils.getConnection;

/**
 * Created by Dell1 on 11/05/2017.
 */

public class DaoBeans {

    Connection con;
    PreparedStatement pst;
    HashMap<String,String> map;
    String loginname,pw;

    public DaoBeans() throws SQLException,Exception
    {
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        con=getConnection();

        String sql="select * from powerdb.USER_LOGIN";
        pst=con.prepareStatement(sql);
        map=new HashMap<>();

    }


    public void cleanUp() throws Exception {

        if (pst != null) {
            pst.close();

        }
        if (con != null) {
            con.close();
        }

    }

    public HashMap<String,String> doLogin() throws SQLException {
        UserDetails userDetails=new UserDetails();
        try(ResultSet rst=pst.executeQuery()){
            while(rst.next()){

                loginname=rst.getString("LOGIN_NAME");
                pw=rst.getString("PW");
                userDetails=new UserDetails(loginname,pw);
                map.put("LOGIN_NAME",loginname);
                map.put("PW",pw);
                Log.e("userdetail-----",loginname+pw);


            }


        }
        return map;


    }

}
