package com.example.minor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    private String[][] doctor_detail1 =
            {
                    {"Doctor Name : Ajit Saste","Hospital Address: Indore","Exp:5yr","Mobile No:9876543213","630"},
                    {"Doctor Name : Parasad Pawar","Hospital Address: Dewas","Exp:15yr","Mobile No:9876563213","930"},
                    {"Doctor Name : Ragini Mishra","Hospital Address: Maksi","Exp:2yr","Mobile No:7876543213","600"},
                    {"Doctor Name : Shashi Devi","Hospital Address: Lucknow","Exp:10yr","Mobile No:9806543213","1000"},
                    {"Doctor Name : Prakas Mishir","Hospital Address: Kanpur","Exp:7yr","Mobile No:9876543013","430"},
            };


    private String[][] doctor_detail2 =
            {
                    {"Doctor Name : Krishna vallabha","Hospital Address: Pune","Exp:1yr","Mobile No:9876543213","630"},
                    {"Doctor Name : Rajendra","Hospital Address: Delhi","Exp:2yr","Mobile No:9876563213","930"},
                    {"Doctor Name : Ragini Pawar","Hospital Address: Kolkata","Exp:3yr","Mobile No:7876543213","600"},
                    {"Doctor Name : Sushmita Devi","Hospital Address: Ranchi","Exp:10yr","Mobile No:9806543213","1000"},
                    {"Doctor Name : Prakas Rao Mishir","Hospital Address: Kanpur","Exp:7yr","Mobile No:9876543013","430"},
            };


    private String[][] doctor_detail3 =
            {
                    {"Doctor Name : Krishna Murti","Hospital Address: Indore","Exp:5yr","Mobile No:9876543213","630"},
                    {"Doctor Name : Manish Tiwari","Hospital Address: Dewas","Exp:15yr","Mobile No:9876563213","930"},
                    {"Doctor Name : Omkashyab","Hospital Address: Maksi","Exp:2yr","Mobile No:7876543213","600"},
                    {"Doctor Name : Prakash Trivedi","Hospital Address: Lucknow","Exp:10yr","Mobile No:9806543213","1000"},
                    {"Doctor Name : Shashikant Tiwari","Hospital Address: Kanpur","Exp:7yr","Mobile No:9876543013","430"},
            };


    private String[][] doctor_detail4 =
            {
                    {"Doctor Name : Anil Kumar","Hospital Address: Indore","Exp:5yr","Mobile No:9876543213","630"},
                    {"Doctor Name : Shaheed pawar","Hospital Address: Dewas","Exp:15yr","Mobile No:9876563213","930"},
                    {"Doctor Name : Krishnappa","Hospital Address: Maksi","Exp:2yr","Mobile No:7876543213","600"},
                    {"Doctor Name : Saksham","Hospital Address: Lucknow","Exp:10yr","Mobile No:9806543213","1000"},
                    {"Doctor Name : Aatmaram","Hospital Address: Kanpur","Exp:7yr","Mobile No:9876543013","430"},
            };


    private String[][] doctor_detail5 =
            {
                    {"Doctor Name : Vinod Singh","Hospital Address: Bhopal","Exp:5yr","Mobile No:9876543213","630"},
                    {"Doctor Name : Prem Vyas","Hospital Address: Ujjain","Exp:15yr","Mobile No:9876563213","930"},
                    {"Doctor Name : Yash kumavat","Hospital Address: Itarsi","Exp:2yr","Mobile No:7876543213","600"},
                    {"Doctor Name : Kumkum Devi","Hospital Address: Jabalpur","Exp:10yr","Mobile No:9806543213","1000"},
                    {"Doctor Name : Karan Mishir","Hospital Address: Gurgoan","Exp:7yr","Mobile No:9876543013","430"},
            };



    TextView tv;
    Button btn;
    HashMap<String,String> item;
    String[][] doctor_details={};
    ArrayList List;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_detail1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_detail2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_detail3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_detail4;
        else
            doctor_details=doctor_detail5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailActivity.this,FindDoctorActivity.class));
            }
        });

        List=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("Line1",doctor_details[i][0]);
            item.put("Line2",doctor_details[i][1]);
            item.put("Line3",doctor_details[i][2]);
            item.put("Line4",doctor_details[i][3]);
            item.put("Line5","Cons Fees: "+doctor_details[i][4]+"/-");
            List.add(item);
        }
        sa=new SimpleAdapter(this,List,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}