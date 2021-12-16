package com.example.evaluacion1y2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class Reservar extends AppCompatActivity {

    private TextView usuario;
    DatePicker calendario;
    private Button btnReloj;
    private int hora, minuto;
    private TextView tipoCancha,fechaReser,horaReser,canchaReser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);
        tipoCancha =findViewById(R.id.tipoCancha);
        usuario=findViewById(R.id.usuarioSesion);
        Contacto nuevo = (Contacto)  getIntent().getSerializableExtra("contacto");
        usuario.setText(nuevo.getNombre());
        btnReloj = findViewById(R.id.botonReloj);
        calendario =findViewById(R.id.calendario);
        fechaReser=findViewById(R.id.fechaReserva);
        horaReser=findViewById(R.id.horaReserva);
        canchaReser=findViewById(R.id.canchaReserva);

    }
    public void fecha(View view){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Seleccione La fecha y Hora:")
                .setMessage("La fecha indicada es:"+calendario.getDayOfMonth()+"/"+(calendario.getMonth()+1)+"/"+calendario.getYear()+" a las:"+btnReloj.getText())
                .setCancelable(true)
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String fe=calendario.getDayOfMonth()+"/"+calendario.getMonth()+"/"+calendario.getYear();
                        String hr=btnReloj.getText().toString();
                        String ca=tipoCancha.getText().toString();
                        if(fe.equals("") || hr.equals("") || ca.equals("")){
                            Toast.makeText(Reservar.this, "Debe Comletar Hora, Fecha y tipo/ para reservar", Toast.LENGTH_SHORT).show();
                        }else {
                            fechaReser.setText("Cancha Reservada Para: " + fe);
                            horaReser.setText("A las: " + hr);
                            canchaReser.setText("Tipo de cancha: " + ca);
                            Toast.makeText(Reservar.this, "Reserva Realizada", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .create()
                .show();
    }

    public void selecHora(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSelect, int minutoSelect) {
                hora= horaSelect;
                minuto = minutoSelect;
                btnReloj.setText(String.format(Locale.getDefault(),"%02d.%02d",hora,minuto));

            }
        };
        TimePickerDialog timePickerDialog =new TimePickerDialog(this, onTimeSetListener, hora, minuto, false);
        timePickerDialog.show();
    }
}