package ma.fst.projetws;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ma.fst.projetws.beans.Etudiant;

public class AddEtudiant extends AppCompatActivity implements View.OnClickListener {

    private EditText nom, prenom;
    private Spinner ville;
    private RadioButton m, f;
    private Button add;
    private RequestQueue requestQueue;
    private static final String insertUrl = "http://10.0.2.2/projetLab9/ws/createEtudiant.php";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        ville = findViewById(R.id.ville);
        m = findViewById(R.id.m);
        f = findViewById(R.id.f);
        add = findViewById(R.id.add);

        requestQueue = Volley.newRequestQueue(this);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==add){
            envoyerEtudiant();
        }
    }

    private void envoyerEtudiant(){
        StringRequest request = new StringRequest(Request.Method.POST, insertUrl,
                    response ->{
                        Log.d("Response", response);
                        try {
                            Type type = new TypeToken<Collection<Etudiant>>() {}.getType();
                            Collection<Etudiant> etudiants = new Gson().fromJson(response, type);
                            for (Etudiant e : etudiants) {
                                Log.d("Etudiant", e.toString());
                            }
                        } catch (Exception ex) {
                            Log.e("GsonError", "Parsing failed: " + ex.getMessage());
                        }
                    },
                    error -> Log.e("Volley", "Erreur: " + error.getMessage())
                ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String sexe = m.isChecked() ? "homme" : "femme";
                Map<String, String> params = new HashMap<>();
                params.put("nom", nom.getText().toString());
                params.put("prenom", prenom.getText().toString());
                params.put("ville", ville.getSelectedItem().toString());
                params.put("sexe", sexe);

                Log.d("DEBUG_INPUTS", "nom=" + nom.getText().toString() + ", prenom=" + prenom.getText().toString() + ", ville=" + ville.getSelectedItem().toString() + ", sexe=" + sexe);
                return params;
            }
        };
        requestQueue.add(request);
    }
}
