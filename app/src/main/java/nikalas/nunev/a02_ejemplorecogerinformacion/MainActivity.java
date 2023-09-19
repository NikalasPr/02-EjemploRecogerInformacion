package nikalas.nunev.a02_ejemplorecogerinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import nikalas.nunev.a02_ejemplorecogerinformacion.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
        //VARIABLES DE INTERFAZ O VISTA
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistrar;

    //VARIABLES DE LA LOGICA
    ArrayList<Usuario> listaUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaUsuarios = new ArrayList<>();

        inicializarVista();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recuperar los datos de las cajas de texto
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                //si hay datos se guardan
                if (email.isEmpty() || password.isEmpty()){
                    //si no hay datos mensaje
                    Toast.makeText(MainActivity.this, "Faltan datos", Toast.LENGTH_SHORT).show();
                }else {
                    //guardar los datos en un objeto usuario
                    Usuario miusuario = new Usuario(email,password);
                    //añadir ese usuario en el arraylist
                    listaUsuarios.add(miusuario);
                    //mensajito resumen
                    Toast.makeText(MainActivity.this, "Guardado"+miusuario.toString(), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void inicializarVista() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrar = findViewById(R.id.btnRegisterMain);
    }


}