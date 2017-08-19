package pe.edu.sise.actcontrolentradacine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActMainActivity extends AppCompatActivity {

    EditText editNombre,editApellidos,editEdad;
    CheckBox chkDocAutorizacion,chkDni;
    RadioButton rbtnsi,rbtnno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_activity_main);

        editNombre=(EditText) findViewById(R.id.editNombres);
        editApellidos=(EditText) findViewById(R.id.editApellidos);
        editEdad=(EditText) findViewById(R.id.editEdad);
        chkDni=(CheckBox) findViewById(R.id.chkDni);
        chkDocAutorizacion=(CheckBox) findViewById(R.id.chkDocAutorizacion);
        //radio botones
        rbtnsi=(RadioButton) findViewById(R.id.rbtnsi);
        rbtnno=(RadioButton) findViewById(R.id.rbtnno);
    }
    public void ValidarIngreso(View view){
        String nombres=editNombre.getText().toString().trim();
        String apellidos=editApellidos.getText().toString().trim();
        String edad= editEdad.getText().toString().trim();
        if(nombres.isEmpty()){
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
        }else if(apellidos.isEmpty()){
            Toast.makeText(this, "Ingrese su apellidos", Toast.LENGTH_SHORT).show();
        }else if(edad.isEmpty()){
            Toast.makeText(this, "Ingrese Su Edad", Toast.LENGTH_SHORT).show();
        }else{
            int edad1=Integer.parseInt(edad);
            if(rbtnsi.isChecked()){
                if(edad1>0 &&edad1<18){
                    if(chkDocAutorizacion.isChecked()){
                        Toast.makeText(this, "Puede Ingresar", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "No puede Ingresar Sin Autorización", Toast.LENGTH_SHORT).show();
                    }
                }else if(edad1>=18){
                    if(chkDni.isChecked()){
                        Toast.makeText(this, "Puede Ingresar", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "No puede Ingresar Sin Dni", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Edad Fuera de rango", Toast.LENGTH_SHORT).show();
                }
            }else if(rbtnno.isChecked()){
                Toast.makeText(this, "No Puede Ingresar sin Boleto", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Seleccione si tiene Boleto", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Resetear(View view){
        editNombre.setText("");
        editApellidos.setText("");
        editEdad.setText("");
        chkDocAutorizacion.setChecked(false);
        chkDni.setChecked(false);
        rbtnsi.setChecked(false);
        rbtnno.setChecked(false);
        editNombre.requestFocus();
    }

}
