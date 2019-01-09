package o.carrion.a.jose.carrionjose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ActividadRaw extends AppCompatActivity {
    TextView datos, hambur, cervz, ensalda, salchi, phambur, pcervz, pensalda, psalchi;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_raw);
        datos = (TextView) findViewById(R.id.lblDatosRaw);

        hambur = (TextView) findViewById(R.id.lblHambur);
        cervz = (TextView) findViewById(R.id.lblCerz);
        ensalda = (TextView) findViewById(R.id.lblEnsald);
        salchi = (TextView) findViewById(R.id.lblSalchi);
        phambur = (TextView) findViewById(R.id.txtPHamb);
        pcervz = (TextView) findViewById(R.id.txtPCervz);
        pensalda = (TextView) findViewById(R.id.txtPEnsald);
        psalchi = (TextView) findViewById(R.id.lblSalchi);


        boton = (Button) findViewById(R.id.btnLeerRaw);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream input = getResources().openRawResource(R.raw.raw_archivo);
                BufferedReader lector = new BufferedReader(new InputStreamReader(input));

                try {
                    String cadena = lector.readLine();
                    String[] arreglo = cadena.split(",");

                    //datos.setText(lector.readLine());

                    String pro1 = arreglo[0].split(",")[0];
                    hambur.setText(pro1);
                    String prec1 = arreglo[1].split(",")[0];
                    phambur.setText(prec1);

                    //String pro2 = arreglo[1].split(",")[1];
                    //hambur.setText(pro2);
                    //String prec2 = arreglo[3].split(",")[0];
                    //phambur.setText(prec2);

                   //String pro2 = arreglo[1].split(",")[0];
                    //cervz.setText(pro2);

                    /* String pEnsal = textoMenu[2];
                    ensalda.setText(pEnsal);

                    String pSalch = textoMenu[3];
                    salchi.setText(pSalch); */


                            lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
