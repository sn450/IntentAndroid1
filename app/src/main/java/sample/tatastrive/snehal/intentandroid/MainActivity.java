package sample.tatastrive.snehal.intentandroid;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chandan S Prasad on 01-Feb-18.
 */

public class MainActivity extends Activity implements OnClickListener {
    EditText editRollno,editName,editMarks;
    Button btnAdd,btnDelete,btnModify,btnView,btnViewAll,btnShowInfo,btnspin;
    SQLiteDatabase db; // Cteated SQLite Database object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editRollno=(EditText)findViewById(R.id.editroll);
        editName=(EditText)findViewById(R.id.editname);
        editMarks=(EditText)findViewById(R.id.editmark);
        btnAdd=(Button)findViewById(R.id.add);
        btnDelete=(Button)findViewById(R.id.del);
        btnModify=(Button)findViewById(R.id.mod);
        btnView=(Button)findViewById(R.id.view);
        btnViewAll=(Button)findViewById(R.id.viewA);
        btnShowInfo=(Button)findViewById(R.id.show);
        btnspin=findViewById(R.id.spin);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
        btnShowInfo.setOnClickListener(this);
        btnspin.setOnClickListener(this);

        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");

    }
    public void onClick(View view)
    {
        if(view==btnAdd)
        {
            if(editRollno.getText().toString().trim().length()==0||
                    editName.getText().toString().trim().length()==0||
                    editMarks.getText().toString().trim().length()==0)
            {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('"+editRollno.getText()+"','"+editName.getText()+
                    "','"+editMarks.getText()+"');");
            showMessage("Success", "Record added");
            clearText();
        }

        if(view==btnDelete)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'",
                    null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM student WHERE rollno='"+editRollno.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();

        }

        if(view==btnModify)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'",
                    null);
            if(c.moveToFirst())
            {
                db.execSQL("UPDATE student SET name='"+editName.getText()+"',marks='"+editMarks.getText()+
                        "' WHERE rollno='"+editRollno.getText()+"'");
                showMessage("Success", "Record Modified");
            }
            else
            {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }

        if(view==btnView)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'",
                    null);
            if(c.moveToFirst())
            {
                editName.setText(c.getString(1));
                editMarks.setText(c.getString(2));
            }
            else
            {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }
        }

        if(view==btnViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM student", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Rollno: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Marks: "+c.getString(2)+"\n\n");
            }
            showMessage("Student Details", buffer.toString());
        }


        if(view==btnShowInfo)
        {
            showMessage("Student Record Application", "Developed By Chandan Prasad");
        }
        if(view==btnspin)
        {
            Intent sp = new Intent("android.intent.action.SPIN");
            startActivity(sp);
        }
    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        editRollno.setText("");
        editName.setText("");
        editMarks.setText("");
        editRollno.requestFocus();
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main,
                    container, false);
            return rootView;
        }
    }
}

